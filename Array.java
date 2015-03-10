package java.sql.start;
   
   import java.util.Map;
   
   /**
  43:  * This interface provides methods for accessing SQL array types.
  44:  *
  45:  * @author Aaron M. Renn (arenn@urbanophile.com)
  46:  */
   public interface Array 
   {
     /**
  50:    * Returns the name of the SQL type of the elements in this
  51:    * array.  This name is database specific.
  52:    *
  53:    * @return The name of the SQL type of the elements in this array.
  54:    * @exception SQLException If an error occurs.
  55:    */
     String getBaseTypeName() throws SQLException;
  
     /**
  59:    * Returns the JDBC type identifier of the elements in this
  60:    * array.  This will be one of the values defined in the 
  61:    * <code>Types</code> class.
  62:    *
  63:    * @return The JDBC type of the elements in this array.
  64:    * @exception SQLException If an error occurs.
  65:    * @see Types
  66:    */
     int getBaseType() throws SQLException;
   
     /**
  70:    * Returns the contents of this array.  This object returned
  71:    * will be an array of Java objects of the appropriate types.
  72:    *
  73:    * @return The contents of the array as an array of Java objects.
  74:    * @exception SQLException If an error occurs.
  75:    */
     Object getArray() throws SQLException;
   
     /**
  79:    * Returns the contents of this array.  The specified
  80:    * <code>Map</code> will be used to override selected mappings 
  81:    * between SQL types and Java classes.
  82:    * 
  83:    * @param map A mapping of SQL types to Java classes.
  84:    * @return The contents of the array as an array of Java objects.
  85:    * @exception SQLException If an error occurs.
  86:    */
     Object getArray(Map<String, Class<?>> map) throws SQLException;
   
     /**
  90:    * Returns a portion of this array starting at <code>start</code>
  91:    * into the array and continuing for <code>count</code>
  92:    * elements.  Fewer than the requested number of elements will be
  93:    * returned if the array does not contain the requested number of elements.
  94:    * The object returned will be an array of Java objects of
  95:    * the appropriate types.
  96:    *
  97:    * @param start The offset into this array to start returning elements from.
  98:    * @param count The requested number of elements to return.
  99:    * @return The requested portion of the array.
 100:    * @exception SQLException If an error occurs.
 101:    */
    Object getArray(long start, int count) throws SQLException;
  
    /**
 105:    * This method returns a portion of this array starting at <code>start</code>
 106:    * into the array and continuing for <code>count</code>
 107:    * elements.  Fewer than the requested number of elements will be
 108:    * returned if the array does not contain the requested number of elements.
 109:    * The object returned will be an array of Java objects.  The specified
 110:    * <code>Map</code> will be used for overriding selected SQL type to
 111:    * Java class mappings.
 112:    *
 113:    * @param start The offset into this array to start returning elements from.
 114:    * @param count The requested number of elements to return.
 115:    * @param map A mapping of SQL types to Java classes.
 116:    * @return The requested portion of the array.
 117:    * @exception SQLException If an error occurs.
 118:    */
    Object getArray(long start, int count, Map<String, Class<?>> map)
      throws SQLException;
  
    /**
 123:    * Returns the elements in the array as a <code>ResultSet</code>.
 124:    * Each row of the result set will have two columns.  The first will be
 125:    * the index into the array of that row's contents.  The second will be
 126:    * the actual value of that array element.
 127:    *
 128:    * @return The elements of this array as a <code>ResultSet</code>.
 129:    * @exception SQLException If an error occurs.
 130:    * @see ResultSet
 131:    */
    ResultSet getResultSet() throws SQLException;
  
    /**
 135:    * This method returns the elements in the array as a <code>ResultSet</code>.
 136:    * Each row of the result set will have two columns.  The first will be
 137:    * the index into the array of that row's contents.  The second will be
 138:    * the actual value of that array element.  The specified <code>Map</code>
 139:    * will be used to override selected default mappings of SQL types to
 140:    * Java classes.
 141:    *
 142:    * @param map A mapping of SQL types to Java classes.
 143:    * @return The elements of this array as a <code>ResultSet</code>.
 144:    * @exception SQLException If an error occurs.
 145:    * @see ResultSet
 146:    */
    ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException;
  
    /**
 150:    * This method returns a portion of the array as a <code>ResultSet</code>.
 151:    * The returned portion will start at <code>start</code> into the
 152:    * array and up to <code>count</code> elements will be returned.
 153:    * <p>
 154:    * Each row of the result set will have two columns.  The first will be
 155:    * the index into the array of that row's contents.  The second will be
 156:    * the actual value of that array element.
 157:    *
 158:    * @param start The index into the array to start returning elements from.
 159:    * @param count The requested number of elements to return.
 160:    * @return The requested elements of this array as a <code>ResultSet</code>.
 161:    * @exception SQLException If an error occurs.
 162:    * @see ResultSet
 163:    */
    ResultSet getResultSet(long start, int count) throws SQLException;
    
    /**
 67:    * This method returns a portion of the array as a <code>ResultSet</code>.
 168:    * The returned portion will start at <code>start</code> into the
 169:    * array and up to <code>count</code> elements will be returned.
 170:    *
 171:    * <p> Each row of the result set will have two columns.  The first will be
 172:    * the index into the array of that row's contents.  The second will be
 173:    * the actual value of that array element.  The specified <code>Map</code>
 174:    * will be used to override selected default mappings of SQL types to
 175:    * Java classes.</p>
 176:    *
 177:    * @param start The index into the array to start returning elements from.
 178:    * @param count The requested number of elements to return.
 179:    * @param map A mapping of SQL types to Java classes.
 180:    * @return The requested elements of this array as a <code>ResultSet</code>.
 181:    * @exception SQLException If an error occurs.
 182:    * @see ResultSet
 183:    */  
    ResultSet getResultSet(long start, int count, Map<String, Class<?>> map)
      throws SQLException;
  }
