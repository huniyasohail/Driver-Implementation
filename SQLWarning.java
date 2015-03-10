
   
   package java.sql.start;
   
   /**
  42:  * This exception is thrown when a database warning occurs.
  43:  *
  44:  * @author Aaron M. Renn (arenn@urbanophile.com)
  45:  */
   public class SQLWarning extends SQLException 
   {
     static final long serialVersionUID = 3917336774604784856L;
   
     /**
  51:    * This method initializes a nwe instance of <code>SQLWarning</code>
  52:    * with the specified descriptive error message, SQL state string, and
  53:    * vendor code.
  54:    *
  55:    * @param message A string describing the nature of the error.
  56:    * @param SQLState A string containing the SQL state of the error.
  57:    * @param vendorCode The vendor error code associated with this error.
  58:    */
     public SQLWarning(String message, String SQLState, int vendorCode)
     {
       super(message, SQLState, vendorCode);
     }
   
     /**
  65:    * This method initializes a new instance of <code>SQLWarning</code>
  66:    * with the specified descriptive error message and SQL state string.
  67:    * The vendor error code of this instance will be 0.
  68:    *
  69:    * @param message A string describing the nature of the error.
  70:    * @param SQLState A string containing the SQL state of the error.
  71:    */
     public SQLWarning(String message, String SQLState)
     {
       super(message, SQLState);
     }
   
     /**
  :    * This method initializes a new instance of <code>SQLWarning</code>
  79:    * with the specified descriptive error message.  The SQL state of this
  80:    * instance will be <code>null</code> and the vendor error code will be 0.
  81:    *
  82:    * @param message A string describing the nature of the error.
  83:    */
     public SQLWarning(String message)
     {
       super(message);
     }
   
     /**
  90:    * This method initializes a new instance of <code>SQLWarning</code>
  91:    * that does not have a descriptive messages and SQL state, and which
  92:    * has a vendor error code of 0.
  93:    */
     public SQLWarning()
     {
       super();
     }
   
     /**
 100:    * This method returns the exception that is chained to this object.
 101:    *
 102:    * @return The exception chained to this object, which may be 
 103:    *         <code>null</code>.
 104:    */
    public SQLWarning getNextWarning()
    {
      return (SQLWarning) super.getNextException();
    }
  
    /**
 11:    * This method adds a new exception to the end of the chain of exceptions
 112:    * that are chained to this object.
 113:    *
 114:    * @param w The exception to add to the end of the chain.
 115:    */
    public void setNextWarning(SQLWarning w)
    {
      super.setNextException(w);
    }
  }
