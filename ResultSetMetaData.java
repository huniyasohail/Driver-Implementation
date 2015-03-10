
   
   package java.sql.start;
   
   /**
  42:  * This interface provides a mechanism for obtaining information about
  43:  * the columns that are present in a <code>ResultSet</code>.
  44:  * 
  45:  * <p> Note that in this class column indices start at 1, not 0.</p>
  46:  *
  47:  * @author Aaron M. Renn (arenn@urbanophile.com)
  48:  */
   public interface ResultSetMetaData 
   {
     /**
  52:    * The column does not allow NULL's.
  53:    */
     int columnNoNulls = 0;
   
     /**
  57:    * The column allows NULL's.
  58:    */
     int columnNullable = 1;
   
     /**
  62:    * It is unknown whether or not the column allows NULL's.
  63:    */
     int columnNullableUnknown = 2;
   
     /**
  67:    * This method returns the number of columns in the result set.
  68:    *
  69:    * @return The number of columns in the result set.
  70:    * @exception SQLException If an error occurs.
  71:    */
     int getColumnCount() throws SQLException;
   
     /**
  75:    * This method test whether or not the column is an auto-increment column.
  76:    * Auto-increment columns are read-only.
  77:    *
  78:    * @param columnIndex The index of the column to test.
  79:    * @return <code>true</code> if the column is auto-increment, <code>false</code>
  80:    *         otherwise.
  81:    * @exception SQLException If an error occurs.
  82:    */
     boolean isAutoIncrement(int columnIndex) throws SQLException;
   
     /**
  6:    * This method tests whether or not a column is case sensitive in its values.
  87:    *
  88:    * @param columnIndex The index of the column to test.
  89:    * @return <code>true</code> if the column value is case sensitive,
  90:    *         <code>false</code> otherwise.
  91:    * @exception SQLException If an error occurs.
  92:    */
     boolean isCaseSensitive(int columnIndex) throws SQLException;
   
     /**
  6:    * This method tests whether not the specified column can be used in 
  97:    * a WHERE clause.
  98:    *
  99:    * @param columnIndex The index of the column to test.
 100:    * @return <code>true</code> if the column may be used in a WHERE clause,
 101:    *         <code>false</code> otherwise.
 102:    * @exception SQLException If an error occurs.
 103:    */
    boolean isSearchable(int columnIndex) throws SQLException;
  
    /**
 107:    * This method tests whether or not the column stores a monetary value.
 108:    *
 109:    * @param columnIndex The index of the column to test.
 110:    * @return <code>true</code> if the column contains a monetary value,
 111:    *         <code>false</code> otherwise.
 112:    * @exception SQLException If an error occurs.
 113:    */
    boolean isCurrency(int columnIndex) throws SQLException;
  
    /**
 117:    * This method returns a value indicating whether or not the specified
 118:    * column may contain a NULL value.
 119:    *
 120:    * @param columnIndex The index of the column to test.
 121:    * @return A constant indicating whether or not the column can contain NULL,
 122:    *         which will be one of <code>columnNoNulls</code>,
 123:    *         <code>columnNullable</code>, or <code>columnNullableUnknown</code>.
 124:    * @exception SQLException If an error occurs.
 125:    */
    int isNullable(int columnIndex) throws SQLException;
 
    /**
 129:    * This method tests whether or not the value of the specified column
 130:    * is signed or unsigned.
 131:    *
 132:    * @param columnIndex The index of the column to test.
 133:    * @return <code>true</code> if the column value is signed, <code>false</code>
 134:    *         otherwise.
 135:    * @exception SQLException If an error occurs.
 136:    */
    boolean isSigned(int columnIndex) throws SQLException;
  
    /**
 140:    * This method returns the maximum number of characters that can be used
 141:    * to display a value in this column.
 142:    *
 143:    * @param columnIndex The index of the column to check.
 144:    * @return The maximum number of characters that can be used to display a
 145:    *         value for this column.
 146:    * @exception SQLException If an error occurs.
 147:    */
    int getColumnDisplaySize(int columnIndex) throws SQLException;
  
    /**
 151:    * This method returns a string that should be used as a caption for this
 152:    * column for user display purposes.
 153:    *
 154:    * @param columnIndex The index of the column to check.
 155:    * @return A display string for the column.
 156:    * @exception SQLException If an error occurs.
 157:    */
    String getColumnLabel(int columnIndex) throws SQLException;
  
    /**
 61:    * This method returns the name of the specified column.
 162:    *
 163:    * @param columnIndex The index of the column to return the name of.
 164:    * @return The name of the column.
 165:    * @exception SQLException If an error occurs.
 166:    */
    String getColumnName(int columnIndex) throws SQLException;
  
    /**
 170:    * This method returns the name of the schema that contains the specified
 171:    * column.
 172:    *
 173:    * @param columnIndex The index of the column to check the schema name for.
 174:    * @return The name of the schema that contains the column.
 175:    * @exception SQLException If an error occurs.
 176:    */
    String getSchemaName(int columnIndex) throws SQLException;
  
    /**
 80:    * This method returns the precision of the specified column, which is the
 181:    * number of decimal digits it contains.
 182:    *
 183:    * @param columnIndex The index of the column to check the precision on.
 184:    * @return The precision of the specified column.
 185:    * @exception SQLException If an error occurs.
 186:    */
    int getPrecision(int columnIndex) throws SQLException;
  
    /**
 190:    * This method returns the scale of the specified column, which is the
 191:    * number of digits to the right of the decimal point.
 192:    *
 193:    * @param columnIndex The index column to check the scale of.
 194:    * @return The scale of the column.
 195:    * @exception SQLException If an error occurs.
 196:    */
    int getScale(int columnIndex) throws SQLException;
  
    /**
 200:    * This method returns the name of the table containing the specified
 201:    * column.
 202:    *
 203:    * @param columnIndex The index of the column to check the table name for.
 204:    * @return The name of the table containing the column.
 205:    * @exception SQLException If an error occurs.
 206:    */
    String getTableName(int columnIndex) throws SQLException;
  
    /**
 210:    * This method returns the name of the catalog containing the specified
 211:    * column.
 212:    *
 213:    * @param columnIndex The index of the column to check the catalog name for.
 214:    * @return The name of the catalog containing the column.
 215:    * @exception SQLException If an error occurs.
 216:    */
    String getCatalogName(int columnIndex) throws SQLException;
  
    /**
 20:    * This method returns the SQL type of the specified column.  This will
 221:    * be one of the constants from <code>Types</code>.
 222:    *
 223:    * @param columnIndex The index of the column to check the SQL type of.
 224:    * @return The SQL type for this column.
 225:    * @exception SQLException If an error occurs.
 226:    * @see Types
 227:    */
    int getColumnType(int columnIndex) throws SQLException;
  
    /**
 31:    * This method returns the name of the SQL type for this column.
 232:    *
 233:    * @param columnIndex The index of the column to check the SQL type name for.
 234:    * @return The name of the SQL type for this column.
 235:    * @exception SQLException If an error occurs.
 236:    */
    String getColumnTypeName(int columnIndex) throws SQLException;
  
    /**
 240:    * This method tests whether or not the specified column is read only.
 241:    *
 242:    * @param columnIndex The index of the column to check.
 243:    * @return <code>true</code> if the column is read only, <code>false</code>
 244:    *         otherwise.
 245:    * @exception SQLException If an error occurs.
 246:    */
    boolean isReadOnly(int columnIndex) throws SQLException;
  
    /**
 250:    * This method tests whether or not the column may be writable.  This
 251:    * does not guarantee that a write will be successful.
 252:    *
 253:    * @param columnIndex The index of the column to check for writability.
 254:    * @return <code>true</code> if the column may be writable,
 255:    *         <code>false</code> otherwise.
 256:    * @exception SQLException If an error occurs.
 257:    */
    boolean isWritable(int columnIndex) throws SQLException;
  
    /**
 261:    * This method tests whether or not the column is writable.  This
 262:    * does guarantee that a write will be successful.
 263:    *
 264:    * @param columnIndex The index of the column to check for writability.
 265:    * @return <code>true</code> if the column is writable,
 266:    *         <code>false</code> otherwise.
 267:    * @exception SQLException If an error occurs.
 268:    */
    boolean isDefinitelyWritable(int columnIndex) throws SQLException;
  
    /**
 272:    * This method returns the name of the Java class which will be used to
 273:    * create objects representing the data in this column.
 274:    *
 275:    * @param columnIndex The index of the column to check.
 276:    * @return The name of the Java class that will be used for values in
 277:    *         this column.
 278:    * @exception SQLException If an error occurs.
 279:    */
    String getColumnClassName(int columnIndex) throws SQLException;
  }
