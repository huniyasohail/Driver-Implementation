
   package java.sql.start;
   
   import java.text.DecimalFormat;
  import java.text.ParseException;
   import java.text.SimpleDateFormat;
   
  /**
  46:  * This class is a wrapper around java.util.Date to allow the JDBC
  47:  * driver to identify the value as a SQL Timestamp.  Note that this
  48:  * class also adds an additional field for nano-seconds, and so 
  49:  * is not completely identical to <code>java.util.Date</code> as
  50:  * the <code>java.sql.Date</code> and <code>java.sql.Time</code>
  51:  * classes are.
  52:  *
  53:  * @author Aaron M. Renn (arenn@urbanophile.com)
  4:  */
   public class Timestamp extends java.util.Date
   {
     static final long serialVersionUID = 2745179027874758501L;
   
     /**
  60:    * Used for parsing and formatting this date.
  61:    */
     private static SimpleDateFormat dateFormat =
       new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     private static DecimalFormat decimalFormat = new DecimalFormat("000000000");
     private static StringBuffer sbuf = new StringBuffer(29);
   
     /**
  :     * The nanosecond value for this object
  69:     */
     private int nanos;
   
     /**
  73:    * This method returns a new instance of this class by parsing a
  74:    * date in JDBC format into a Java date.
  75:    *
  76:    * @param str The string to parse.
  77:    * @return The resulting <code>java.sql.Timestamp</code> value. 
  78:    */
     public static Timestamp valueOf(String str)
     {
       int nanos = 0;
       int dot = str.indexOf('.');
       if (dot != -1)
         {
       if (str.lastIndexOf('.') != dot)
         throw new IllegalArgumentException(str);
   
       int len = str.length() - dot - 1;
       if (len < 1 || len > 9)
         throw new IllegalArgumentException(str);
   
       nanos = Integer.parseInt(str.substring(dot + 1));
       for (int i = len; i < 9; i++)
         nanos *= 10;
       
       str = str.substring(0, dot);
   
         }
   
      try
        {
          java.util.Date d;
          synchronized (dateFormat)
        {
          d = (java.util.Date) dateFormat.parseObject(str);
        }
  
      if (d == null)
        throw new IllegalArgumentException(str);
  
      Timestamp ts = new Timestamp(d.getTime() + nanos / 1000000);
      ts.nanos = nanos;
      return ts;
        }
      catch (ParseException e)
        {
      throw new IllegalArgumentException(str);
        }
    }
  
    /**
 22:    * This method initializes a new instance of this class with the
 123:    * specified year, month, and day.
 124:    *
 125:    * @param year The year for this Timestamp (year - 1900)
 126:    * @param month The month for this Timestamp (0-11)
 127:    * @param day The day for this Timestamp (1-31)
 128:    * @param hour The hour for this Timestamp (0-23)
 129:    * @param minute The minute for this Timestamp (0-59)
 130:    * @param second The second for this Timestamp (0-59)
 131:    * @param nanos The nanosecond value for this Timestamp (0 to 999,999,9999)
 132:    * @deprecated
 133:    */
    public Timestamp(int year, int month, int day, int hour, int minute, 
      int second, int nanos)
    {
      super(year, month, day, hour, minute, second);
      this.nanos = nanos;
    }
  
    /**
 142:    * This method initializes a new instance of this class with the
 143:    * specified time value representing the number of milliseconds since 
 144:    * Jan 1, 1970 at 12:00 midnight GMT.
 145:    *
 146:    * @param date The time value to intialize this <code>Time</code> to.
 147:    */
    public Timestamp(long date)
    {
      super(date - (date % 1000));
      nanos = (int) (date % 1000) * 1000000;
    }
  
    /**
 155:    * Return the value of this Timestamp as the number of milliseconds 
 156:    * since Jan 1, 1970 at 12:00 midnight GMT.
 157:    */
    public long getTime()
    {
      return super.getTime() + (nanos / 1000000);
    }
  
    /**
 164:    * This method returns this date in JDBC format.
 165:    *
 166:    * @return This date as a string.
 167:    */
    public String toString()
    {
      synchronized (dateFormat)
        {
          sbuf.setLength(0);
     dateFormat.format(this, sbuf, null);
      sbuf.append('.');
      decimalFormat.format(nanos, sbuf, null);
      int end = sbuf.length() - 1;
      while (end > 20 && sbuf.charAt(end) == '0')
        end--;
      return sbuf.substring(0, end + 1);
        }
    }
  
    /**
 4:     * This method returns the nanosecond value for this object.
 185:     * @return The nanosecond value for this object.
 186:     */
    public int getNanos()
    {
     return nanos;
    }
  
    /**
 193:    * This method sets the nanosecond value for this object.
 194:    *
 195:    * @param nanos The nanosecond value for this object.
 196:    */
    public void setNanos(int nanos)
    {
      this.nanos = nanos;
    }
  
    /**
 203:    * This methods tests whether this object is earlier than the specified
 204:    * object.
 205:    *
 206:    * @param ts The other <code>Timestamp</code> to test against.
 207:    * @return <code>true</code> if this object is earlier than the other object,
 208:    *         <code>false</code> otherwise.
 209:    */
    public boolean before(Timestamp ts)
    {
      long time1 = getTime();
      long time2 = ts.getTime();
      if (time1 < time2 || (time1 == time2 && getNanos() < ts.getNanos()))
        return true;
      return false;
    }
  
    /**
 220:    * This methods tests whether this object is later than the specified
 221:    * object.
 222:    *
 223:    * @param ts The other <code>Timestamp</code> to test against.
 224:    *
 225:    * @return <code>true</code> if this object is later than the other object,
 226:    * <code>false</code> otherwise.
 227:    */
    public boolean after(Timestamp ts)
    {
      long time1 = getTime();
      long time2 = ts.getTime();
      if (time1 > time2 || (time1 == time2 && getNanos() > ts.getNanos()))
        return true;
      return false;
    }
  
    /**
 8:    * This method these the specified <code>Object</code> for equality
 239:    * against this object.  This will be true if an only if the specified
 240:    * object is an instance of <code>Timestamp</code> and has the same
 241:    * time value fields.
 242:    *
 243:    * @param obj The object to test against for equality.
 244:    *
 245:    * @return <code>true</code> if the specified object is equal to this
 246:    * object, <code>false</code> otherwise.
 247:    */
    public boolean equals(Object obj)
    {
      if (!(obj instanceof Timestamp))
        return false;
  
      return equals((Timestamp) obj);
    }
  
    /**
 257:    * This method tests the specified timestamp for equality against this
 258:    * object.  This will be true if and only if the specified object is
 259:    * not <code>null</code> and contains all the same time value fields
 260:    * as this object.
 261:    *
 262:    * @param ts The <code>Timestamp</code> to test against for equality.
 263:    *
 264:    * @return <code>true</code> if the specified object is equal to this
 265:    * object, <code>false</code> otherwise.
 266:    */
    public boolean equals(Timestamp ts)
   {
      if (ts == null)
        return false;
  
      if (ts.getTime() != getTime())
        return false;
  
      if (ts.getNanos() != getNanos())
        return false;
  
      return true;
    }
  
    /**
 282:    * Compares this <code>Timestamp</code> to another one.
 283:    * 
 284:    * @param ts The other Timestamp.
 285:    * @return <code>0</code>, if both <code>Timestamp</code>'s represent exactly
 286:    *         the same date, a negative value if this <code>Timestamp</code> is
 287:    *         before the specified <code>Timestamp</code> and a positive value
 288:    *         otherwise.
 289:    * @since 1.2
 290:    */
    public int compareTo(Timestamp ts)
    {
      int s = super.compareTo((java.util.Date) ts);
      if (s != 0)
        return s;
      // If Date components were equal, then we check the nanoseconds.
      return nanos - ts.nanos;
    }
  
    /**
 301:    * Compares this <code>Timestamp</code> to another one. This behaves like
 302:    * <code>compareTo(Timestamp)</code>, but it may throw a
 303:    * <code>ClassCastException</code>, if the specified object is not of type
 304:    * <code>Timestamp</code>.
 305:    * 
 306:    * @param obj The object to compare with.
 307:    * @return <code>0</code>, if both <code>Timestamp</code>'s represent exactly
 308:    *         the same date, a negative value if this <code>Timestamp</code> is
 309:    *         before the specified <code>Timestamp</code> and a positive value
 310:    *         otherwise.
 311:    * @exception ClassCastException if obj is not of type Timestamp.
 312:    * @see #compareTo(Timestamp)
 313:    * @since 1.2
 314:    */
    public int compareTo(java.util.Date obj)
    {
      return compareTo((Timestamp) obj);
    }
  }
