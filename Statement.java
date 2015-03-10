 
   
   package java.sql.start;
   
   /**
  42:  * This interface provides a mechanism for executing SQL statements.
  43:  *
  44:  * @author Aaron M. Renn (arenn@urbanophile.com)
  45:  */
   public interface Statement 
   {
     int CLOSE_CURRENT_RESULT = 1;
     int KEEP_CURRENT_RESULT = 2;
     int CLOSE_ALL_RESULTS = 3;
     int SUCCESS_NO_INFO = -2;
     int EXECUTE_FAILED = -3;
     int RETURN_GENERATED_KEYS = 1;
     int NO_GENERATED_KEYS = 2;
   
     /**
  57:    * This method executes the specified SQL SELECT statement and returns a
  58:    * (possibly empty) <code>ResultSet</code> with the results of the query.
  59:    *
  60:    * @param sql The SQL statement to execute.
  61:    * @return The result set of the SQL statement.
  62:    * @exception SQLException If an error occurs.
  63:    */
     ResultSet executeQuery(String sql) throws SQLException;
   
     /**
  67:    * This method executes the specified SQL INSERT, UPDATE, or DELETE statement
  68:    * and returns the number of rows affected, which may be 0.
  69:    * 
  70:    * @param sql The SQL statement to execute.
  71:    * @return The number of rows affected by the SQL statement.
  72:    * @exception SQLException If an error occurs.
  73:    */
     int executeUpdate(String sql) throws SQLException;
   
     /**
  77:    * This method closes the statement and frees any associated resources.
  78:    *
  79:    * @exception SQLException If an error occurs.
  80:    */
     void close() throws SQLException;
   
     /**
  84:    * This method returns the maximum length of any column value in bytes.
  85:    *
  86:    * @return The maximum length of any column value in bytes.
  87:    * @exception SQLException If an error occurs.
  88:    */
     int getMaxFieldSize() throws SQLException;
   
     /**
  92:    * This method sets the limit for the maximum length of any column in bytes.
  93:    *
  94:    * @param maxSize The new maximum length of any column in bytes.
  95:    * @exception SQLException If an error occurs.
  96:    */
     void setMaxFieldSize(int maxSize) throws SQLException;
  
     /**
 100:    * This method returns the maximum possible number of rows in a result set.
 101:    *
 102:    * @return The maximum possible number of rows in a result set.
 103:    * @exception SQLException If an error occurs.
 104:    */
    int getMaxRows() throws SQLException;
  
    /**
 108:    * This method sets the maximum number of rows that can be present in a
 109:    * result set.
 110:    *
 111:    * @param maxRows The maximum possible number of rows in a result set.
 112:    * @exception SQLException If an error occurs.
 113:    */
    void setMaxRows(int maxRows) throws SQLException;
  
    /**
 117:    * This method sets the local escape processing mode on or off.  The
 118:    * default value is on.
 119:    *
 120:    * @param escape <code>true</code> to enable local escape processing, 
 121:    *               <code>false</code> to disable it.
 122:    * @exception SQLException If an error occurs.
 123:    */
    void setEscapeProcessing(boolean escape) throws SQLException;
  
    /**
 127:    * The method returns the number of seconds a statement may be in process
 128:    * before timing out.  A value of 0 means there is no timeout.
 129:    *
 130:    * @return The SQL statement timeout in seconds.
 131:    * @exception SQLException If an error occurs.
 32:    */
    int getQueryTimeout() throws SQLException;
  
    /**
 36:    * This method sets the number of seconds a statement may be in process
 137:    * before timing out.  A value of 0 means there is no timeout.
 138:    *
 139:    * @param seconds The new SQL statement timeout value.
 140:    * @exception SQLException If an error occurs.
 141:    */
    void setQueryTimeout(int seconds) throws SQLException;
  
    /**
 45:    * This method cancels an outstanding statement, if the database supports
 146:    * that operation.
 147:    *
 148:    * @exception SQLException If an error occurs.
 149:    */
    void cancel() throws SQLException;
  
    /**
 153:    * This method returns the first SQL warning attached to this statement.
 154:    * Subsequent warnings will be chained to this one.
 155:    *
 156:    * @return The first SQL warning for this statement.
 157:    * @exception SQLException If an error occurs.
 158:    */
    SQLWarning getWarnings() throws SQLException;
  
    /**
 162:    * This method clears any SQL warnings that have been attached to this
 163:    * statement.
 164:    *
 165:    * @exception SQLException If an error occurs.
 166:    */
    void clearWarnings() throws SQLException;
  
    /**
 170:    * This method sets the cursor name that will be used by the result set.
 171:    *
 172:    * @param name The cursor name to use for this statement.
 173:    * @exception SQLException If an error occurs.
 174:    */
    void setCursorName(String name) throws SQLException;
  
    /**
 178:    * This method executes an arbitrary SQL statement of any time.  The
 179:    * methods <code>getResultSet</code>, <code>getMoreResults</code> and
 180:    * <code>getUpdateCount</code> retrieve the results.
 181:    *
 182:    * @return <code>true</code> if a result set was returned, <code>false</code>
 183:    *         if an update count was returned.
 184:    * @exception SQLException If an error occurs.
 185:    */
    boolean execute(String sql) throws SQLException;
  
    /**
 189:    * This method returns the result set of the SQL statement that was
 190:    * executed.  This should be called only once per result set returned.
 191:    *
 192:    * @return The result set of the query, or <code>null</code> if there was
 193:    *         no result set (for example, if the statement was an UPDATE).
 194:    * @exception SQLException If an error occurs.
 195:    * @see #execute(String)
 196:    * @see #execute(String, int)
 197:    * @see #execute(String, int[])
 198:    * @see #execute(String, String[])
 199:    */
    ResultSet getResultSet() throws SQLException;
 
    /**
 203:    * This method returns the update count of the SQL statement that was
 204:    * executed.  This should be called only once per executed SQL statement.
 205:    *
 206:    * @return The update count of the query, or -1 if there was no update
 207:    *         count (for example, if the statement was a SELECT).
 208:    * @exception SQLException If an error occurs.
 209:    * @see #execute(String)
 210:    * @see #execute(String, int)
 211:    * @see #execute(String, int[])
 212:    * @see #execute(String, String[])
 213:    */
    int getUpdateCount() throws SQLException;
  
    /**
 217:    * This method advances the result set pointer to the next result set, 
 218:    * which can then be retrieved using <code>getResultSet</code>
 219:    *
 220:    * @return <code>true</code> if there is another result set, 
 221:    *         <code>false</code> otherwise (for example, the next result is an
 222:    *         update count).
 223:    * @exception SQLException If an error occurs.
 224:    * @see #execute(String)
 225:    * @see #execute(String, int)
 226:    * @see #execute(String, int[])
 227:    * @see #execute(String, String[])
 228:    */
    boolean getMoreResults() throws SQLException;
  
    /**
 232:    * This method informs the driver which direction the result set will
 233:    * be accessed in.
 234:    *
 235:    * @param direction The direction the result set will be accessed in (?????)
 236:    * @exception SQLException If an error occurs.
 237:    */
    void setFetchDirection(int direction) throws SQLException;
  
    /**
 241:    * This method returns the current direction that the driver thinks the
 242:    * result set will be accessed int.
 243:    *
 244:    * @return The direction the result set will be accessed in (????)
 245:    * @exception SQLException If an error occurs.
 246:    */
    int getFetchDirection() throws SQLException;
  
    /**
 250:    * This method informs the driver how many rows it should fetch from the
 251:    * database at a time.
 252:    *
 253:    * @param numRows The number of rows the driver should fetch at a time
 254:    *                to populate the result set.
 255:    * @exception SQLException If an error occurs.
 256:    */
    void setFetchSize(int numRows) throws SQLException;
  
    /**
 260:    * This method returns the number of rows the driver believes should be
 261:    * fetched from the database at a time.
 262:    *
 263:    * @return The number of rows that will be fetched from the database at a time.
 264:    * @exception SQLException If an error occurs.
 265:    */
    int getFetchSize() throws SQLException;
  
    /**
 269:    * This method returns the concurrency type of the result set for this
 270:    * statement. This will be one of the concurrency types defined in
 271:    * <code>ResultSet</code>.
 272:    *
 273:    * @return The concurrency type of the result set for this statement.
 274:    * @exception SQLException If an error occurs.
 275:    * @see ResultSet
 276:    */
    int getResultSetConcurrency() throws SQLException;
  
    /**
 280:    * This method returns the result set type for this statement.  This will
 281:    * be one of the result set types defined in <code>ResultSet</code>.
 282:    *
 283:    * @return The result set type for this statement.
 284:    * @exception SQLException If an error occurs.
 285:    * @see ResultSet
 286:    */
    int getResultSetType() throws SQLException;
  
    /**
 290:    * This method adds a SQL statement to a SQL batch.  A driver is not
 291:    * required to implement this method.
 292:    *
 293:    * @param sql The sql statement to add to the batch.
 294:    * @exception SQLException If an error occurs.
 295:    */
    void addBatch(String sql) throws SQLException;
  
    /**
 299:    * This method clears out any SQL statements that have been populated in
 300:    * the current batch.  A driver is not required to implement this method.
 301:    *
 302:    * @exception SQLException If an error occurs.
 303:    */
    void clearBatch() throws SQLException;
  
    /**
 307:    * This method executes the SQL batch and returns an array of update
 308:    * counts - one for each SQL statement in the batch - ordered in the same
 309:    * order the statements were added to the batch.  A driver is not required
 310:    * to implement this method.
 311:    *
 312:    * @return An array of update counts for this batch.
 313:    * @exception SQLException If an error occurs.
 314:    */
    int[] executeBatch() throws SQLException;
  
    /**
 318:    * This method returns the <code>Connection</code> instance that was
 319:    * used to create this object.
 320:    *
 321:    * @return The connection used to create this object.
 322:    * @exception SQLException If an error occurs.
 323:    */
    Connection getConnection() throws SQLException;
  
    /**
 327:    * @since 1.4
 328:    */
    boolean getMoreResults(int current) throws SQLException;
  
    /**
 332:    * @since 1.4
 333:    */
    ResultSet getGeneratedKeys() throws SQLException;
  
    /**
 337:    * @since 1.4
 338:    */
    int executeUpdate(String sql, int autoGeneratedKeys)
      throws SQLException;
  
    /**
 343:    * @since 1.4
 344:    */
    int executeUpdate(String sql, int[] columnIndexes)
      throws SQLException;
  
    /**
 349:    * @since 1.4
 350:    */
   int executeUpdate(String sql, String[] columnNames)
      throws SQLException;
  
    /**
 355:    * @since 1.4
 356:    */
    boolean execute(String sql, int autoGeneratedKeys)
      throws SQLException;
  
    /**
 361:    * @since 1.4
 362:    */
    boolean execute(String sql, int[] columnIndexes) throws SQLException;
  
    /**
 366:    * @since 1.4
 367:    */
    boolean execute(String sql, String[] columnNames)
      throws SQLException;
  
    /**
 372:    * @since 1.4
 373:    */
    int getResultSetHoldability() throws SQLException;
  }
