 package java.sql.start;
   
   import java.text.ParseException;
   import java.text.SimpleDateFormat;
   
   /**
  44:   * This class is a wrapper around java.util.Date to allow the JDBC
  45:   * driver to identify the value as a SQL Date.
  46:   *
  47:   * @author Aaron M. Renn (arenn@urbanophile.com)
  48:   */
   public class Date extends java.util.Date 
   {
     static final long serialVersionUID = 1511598038487230103L;
   
     /**
  54:    * Used for parsing and formatting this date.
  55:    */
     private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   
     /**
  59:    * This method initializes a new instance of this class with the
  60:    * specified year, month, and day.
  61:    *
  62:    * @param year The year of this date minue 1900.
  63:    * @param month The month of this date (0-11).
  64:    * @param day The day of this date (1-31).
  65:    *
  66:    * @deprecated
  67:    */
     public Date(int year, int month, int day)
     {
       super(year, month, day);  
     }
   
     /**
  4:    * This method initializes a new instance of this class with the
  75:    * specified time value representing the number of milliseconds since 
  76:    * Jan 1, 1970 at 12:00 midnight GMT.
  77:    *
  78:    * @param date The time value to intialize this date to.
  79:    */
     public Date(long date)
     {
       super(date);
     }
   
     /**
  :    * This method always throws an IllegalArgumentException.
  87:    *
  88:    * @throws IllegalArgumentException when it's called.
  89:    * @deprecated
  90:    */
     public int getHours() throws IllegalArgumentException
     {
       throw new IllegalArgumentException();
     }
   
     /**
  97:    * This method always throws an IllegalArgumentException.
  98:    *
  99:    * @throws IllegalArgumentException when it's called.
 100:    * @deprecated
 101:    */
    public int getMinutes() throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 08:    * This method always throws an IllegalArgumentException.
 109:    *
 110:    * @throws IllegalArgumentException when it's called.
 111:    * @deprecated
 112:    */
    public int getSeconds() throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 119:    * This method always throws an IllegalArgumentException.
 120:    *
 121:    * @throws IllegalArgumentException when it's called.
 122:    * @deprecated
 123:    */
    public void setHours(int newValue) throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 130:    * This method always throws an IllegalArgumentException.
 131:    *
 132:    * @throws IllegalArgumentException when it's called.
 133:    * @deprecated
 134:    */
    public void setMinutes(int newValue) throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 141:    * This method always throws an IllegalArgumentException.
 142:    *
 143:    * @throws IllegalArgumentException when it's called.
 144:    * @deprecated
 145:    */
    public void setSeconds(int newValue) throws IllegalArgumentException
    {
      throw new IllegalArgumentException();
    }
  
    /**
 2:    * This method returns a new instance of this class by parsing a
 153:    * date in JDBC format into a Java date.
 154:    *
 155:    * @param str The string to parse.
 156:    * @return The resulting <code>java.sql.Date</code> value.
 157:    */
    public static Date valueOf (String str)
    {
      try 
        {
     java.util.Date d = (java.util.Date) sdf.parseObject(str);
 
      if (d == null)
        throw new IllegalArgumentException(str);
      else
        return new Date(d.getTime());
        }
      catch (ParseException e)
        {
      throw new IllegalArgumentException(str);
        }
    }
  
    /**
 176:    * This method returns this date in JDBC format.
 177:    *
 178:    * @return This date as a string.
 179:    */
    public String toString()
    {
      return sdf.format(this);
    }
  }
