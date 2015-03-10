 
   package java.sql.start;
   
   /**
  41:  * @since 1.4
  42:  */
   public interface ParameterMetaData 
  {
     int parameterNoNulls = 0;
   
     int parameterNullable = 1;
   
     int parameterNullableUnknown = 2;
   
     int parameterModeUnknown = 0;
   
     int parameterModeIn = 1;
   
     int parameterModeInOut = 2;
   
     int parameterModeOut = 4;
   
     /**
  60:    * @since 1.4
  61:    */
     int getParameterCount() throws SQLException;
   
     /**
  65:    * @since 1.4
  66:    */
     int isNullable(int param) throws SQLException;
   
     /**
  70:    * @since 1.4
  71:    */
     boolean isSigned(int param) throws SQLException;
   
     /**
  75:    * @since 1.4
  76:    */
     int getPrecision(int param) throws SQLException;
   
     /**
  80:    * @since 1.4
  81:    */
     int getScale(int param) throws SQLException;
   
     /**
  85:    * @since 1.4
  86:    */
     int getParameterType(int param) throws SQLException;
   
     /**
  90:    * @since 1.4
  91:    */
     String getParameterTypeName(int param) throws SQLException;
   
     /**
  95:    * @since 1.4
  96:    */
     String getParameterClassName(int param) throws SQLException;
   
     /**
 100:    * @since 1.4
 101:    */
    int getParameterMode(int param) throws SQLException;
  }