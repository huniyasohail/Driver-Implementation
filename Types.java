 package java.sql.start;
  
   /**
  42:  * This class contains constants that are used to identify SQL data types.
  43:  *
  44:  * @author Aaron M. Renn (arenn@urbanophile.com)
  45:  */
   public class Types 
   {
     // These should be self explanatory.  People need a SQL book, not
     // Javadoc comments for these.
    public static final int BIT = -7;
     public static final int TINYINT = -6;
     public static final int SMALLINT = 5;
     public static final int INTEGER = 4;
     public static final int BIGINT = -5;
    public static final int FLOAT = 6;
     public static final int REAL = 7;
     public static final int DOUBLE = 8;
     public static final int NUMERIC = 2;
     public static final int DECIMAL = 3;
     public static final int CHAR = 1;
     public static final int VARCHAR = 12;
     public static final int LONGVARCHAR = -1;
     public static final int DATE = 91;
     public static final int TIME = 92;
     public static final int TIMESTAMP = 93;
     public static final int BINARY = -2;
     public static final int VARBINARY = -3;
     public static final int LONGVARBINARY = -4;
     public static final int NULL = 0;
     public static final int OTHER = 1111;
     public static final int JAVA_OBJECT = 2000;
     public static final int DISTINCT = 2001;
     public static final int STRUCT = 2002;
     public static final int ARRAY = 2003;
     public static final int BLOB = 2004;
     public static final int CLOB = 2005;
     public static final int REF = 2006;
    public static final int DATALINK = 70;
     public static final int BOOLEAN = 16;
   
     // This class can't be instantiated.
     private Types()
     {
     }
   }