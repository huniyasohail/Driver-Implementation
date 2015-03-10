package java.sql.start;
   
   /**
  41:  * This class extends <code>SQLException</code> to count the successful
  42:  * updates in each statement in a batch that was successfully updated prior 
  43:  * to the error.
  44:  *
  45:  * @author Aaron M. Renn (arenn@urbanophile.com)
  46:  */
   public class BatchUpdateException extends SQLException 
   {     static final long serialVersionUID = 5977529877145521757L;
   
     /**
  52:    * This is the array of update counts for the commands which completed
  53:    * successfully prior to the error.
  54:    */
     private int[] updateCounts;
   
     /**
  58:    * This method initializes a new instance of <code>BatchUpdateException</code>
  59:    * with the specified descriptive error message, SQL state, and update count
  60:    * information.  The vendor specific error code will be initialized to 0.
  61:    *
  62:    * @param message The descriptive error message.
  63:    * @param SQLState The SQL state information for this error.
  64:    * @param vendorCode
  65:    * @param updateCounts The update count information for this error.
  66:    */
     public BatchUpdateException(String message, String SQLState, int vendorCode,
       int[] updateCounts)
     {
       super(message, SQLState, vendorCode);
       this.updateCounts = updateCounts;
     }
   
     /**
  5:    * This method initializes a new instance of <code>BatchUpdateException</code>
  76:    * with the specified descriptive error message, SQL state, and update count
  77:    * information.  The vendor specific error code will be initialized to 0.
  78:    *
  79:    * @param message The descriptive error message.
  80:    * @param SQLState The SQL state information for this error.
  81:    * @param updateCounts The update count information for this error.
  82:    */
     public BatchUpdateException(String message, String SQLState,
       int[] updateCounts)
     {
       super(message, SQLState);
       this.updateCounts = updateCounts;  
     }
   
     /**
  91:    * This method initializes a new instance of <code>BatchUpdateException</code>
  92:    * with the specified descriptive error message and update count information.
  93:    * The SQL state will be initialized to <code>null</code> and the vendor
  94:    * specific error code will be initialized to 0.
  95:    *
  96:    * @param message The descriptive error message.
  97:    * @param updateCounts The update count information for this error.
  98:    */
     public BatchUpdateException(String message, int[] updateCounts)
    {
      super(message);
      this.updateCounts = updateCounts;
    }
  
    /**
 106:    * Initializes a new instance of <code>BatchUpdateException</code>
 107:    * with the specified update count information and no descriptive error
 108:    * message.  This SQL state will be initialized to <code>null</code> and
 109:    * the vendor specific error code will be initialized to 0.
 110:    *
 111:    * @param updateCounts The update count array.
 112:    */
    public BatchUpdateException(int[] updateCounts)
    {
      this.updateCounts = updateCounts;
    }
  
    /**
 9:    * Initializes a new instance of <code>BatchUpdateException</code>
 120:    * with no descriptive error message.  The SQL state and update count will
 121:    * be initialized to <code>null</code> and the vendor specific error code will 
 122:    * initialized to 0.
 123:    */
    public BatchUpdateException()
    {
      super();
    }
  
    /**
 130:    * This method returns the update count information for this error.  If
 131:    * not <code>null</code> this is an array of <code>int</code>'s that are
 132:    * the update accounts for each command that was successfully executed.
 133:    * The array elements are in the order that the commands were executed.
 134:    *
 135:    * @return The update count information, which may be <code>null</code>.
 136:    */
    public int[] getUpdateCounts()
    {
      return updateCounts;
    }
  }
