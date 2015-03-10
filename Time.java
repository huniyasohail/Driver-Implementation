package java.sql.start;
   
   import java.text.ParseException;
   import java.text.SimpleDateFormat;
  
   /**
  46:  * This class is a wrapper around java.util.Date to allow the JDBC
  47:  * driver to identify the value as a SQL Time.
  48:  *
  49:  * @author Aaron M. Renn (arenn@urbanophile.com)
  50:  */
   public class Time extends java.util.Date
   {
     static final long serialVersionUID = 8397324403548013681L;
   
     /**
  56:    * Used for parsing and formatting this date.
  57:    */
     private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
   
     /**
  61:    * This method always throws an IllegalArgumentException.
  62:    *
  63:    * @throws IllegalArgumentException when it's called.
  64:    * @deprecated
  65:    */
     public int getDate() throws IllegalArgumentException
     {
       throw new IllegalArgumentException();
     }
   
     /**
  72:    * This method always throws an IllegalArgumentException.
  73:    *
  74:    * @throws IllegalArgumentException when it's called.
  75:    * @deprecated
  76:    */
     public int getDay() throws IllegalArgumentException
     {
       throw new IllegalArgumentException();
     }
                                                                                                                                                                                                                                                                                                                                                                                                                                                  
     /**
  3:    * This method always throws an IllegalArgumentException.
  84:    *
  85:    * @throws IllegalArgumentException when it's called.
  86:    * @deprecated
  87:    */
     public int getMonth() throws IllegalArgumentException
     {
       throw new IllegalArgumentException();
     }
   
     /**
  94:    * This method always throws an IllegalArgumentException.
  95:    *
  96:    * @throws IllegalArgumentException when it's called.
  97:    * @deprecated
  8:    */
     public int getYear() throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 105:    * This method always throws an IllegalArgumentException.
 106:    *
 107:    * @throws IllegalArgumentException when it's called.
 108:    * @deprecated
 109:    */
    public void setDate(int newValue) throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 116:    * This method always throws an IllegalArgumentException.
 117:    *
 118:    * @throws IllegalArgumentException when it's called.
 119:    * @deprecated
 120:    */
    public void setMonth(int newValue) throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 27:    * This method always throws an IllegalArgumentException.
 128:    *
 129:    * @throws IllegalArgumentException when it's called.
 130:    * @deprecated
 131:    */
    public void setYear(int newValue) throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 8:    * This method returns a new instance of this class by parsing a
 139:    * date in JDBC format into a Java date.
 140:    *
 141:    * @param str The string to parse.
 142:    * @return The resulting <code>java.sql.Time</code> value.
 143:    */
    public static Time valueOf (String str)
    {
      try
        {
     java.util.Date d = (java.util.Date) sdf.parseObject(str);
  
      if (d == null)
        throw new IllegalArgumentException(str);
      else
        return new Time(d.getTime());
        }
      catch (ParseException e)
        {
      throw new IllegalArgumentException(str);
        }
    }
  
    /**
 62:     * This method initializes a new instance of this class with the
 163:     * specified year, month, and day.
 164:     *
 165:     * @param hour The hour for this Time (0-23)
 166:     * @param minute The minute for this time (0-59)
 167:     * @param second The second for this time (0-59)
 168:     * @deprecated
 169:     */
   public Time(int hour, int minute, int second)
    {
      super(System.currentTimeMillis());
 
      setHours(hour);
      setMinutes(minute);
     setSeconds(second);
    }
  
    /**
 0:    * This method initializes a new instance of this class with the
 181:    * specified time value representing the number of milliseconds since 
 182:    * Jan 1, 1970 at 12:00 midnight GMT.
 183:    *
 184:    * @param date The time value to intialize this <code>Time</code> to.
 185:    */
    public Time(long date)
    {
      super(date);
    }
  
    /**
 2:    * This method returns this date in JDBC format.
 193:    *
 194:    * @return This date as a string.
 195:    */
    public String toString ()
    {
      return sdf.format (this);
    }
  
  }