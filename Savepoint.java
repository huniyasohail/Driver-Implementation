package java.sql.start;
   
   /**
  42:  * @since 1.4
  43:  */
   public interface Savepoint 
   {
     /**
  47:    * @since 1.4
  48:    */
     int getSavepointId() throws SQLException;
   
     /**
  52:    * @since 1.4
  53:    */
     String getSavepointName() throws SQLException;
   }