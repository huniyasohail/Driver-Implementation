 package java.sql.start;
 
   import java.io.InputStream;
   import java.io.Reader;
   import java.math.BigDecimal;
   import java.net.URL;
   import java.util.Calendar;
   
   /**
  47:  * This interface provides a mechanism for executing pre-compiled
  48:  * statements.  This provides greater efficiency when calling the same
  49:  * statement multiple times.  Parameters are allowed in a statement,
  50:  * providings for maximum reusability.
  51:  * 
  52:  * <p> Note that in this class parameter indices start at 1, not 0.</p>
  53:  *
  54:  * @author Aaron M. Renn (arenn@urbanophile.com)
  55:  */
   public interface PreparedStatement extends Statement 
   {
     /**
  59:    * This method executes a prepared SQL query and returns its ResultSet.
  60:    *
  61:    * @return The ResultSet of the SQL statement.
  62:    * @exception SQLException If an error occurs.
  63:    */
     ResultSet executeQuery() throws SQLException;
   
     /**
  67:    * This method executes an SQL INSERT, UPDATE or DELETE statement.  SQL
  68:    * statements that return nothing such as SQL DDL statements can be executed.
  69:    *
  70:    * @return The result is either the row count for INSERT, UPDATE or DELETE
  71:    *         statements; or 0 for SQL statements that return nothing.
  72:    * @exception SQLException If an error occurs.
  73:    */
     int executeUpdate() throws SQLException;
   
     /**
  7:    * This method populates the specified parameter with a SQL NULL value
  78:    * for the specified type.
  79:    *
  80:    * @param index The index of the parameter to set.
  81:    * @param sqlType The SQL type identifier of the parameter from 
  82:    *                <code>Types</code>
  83:    *
  84:    * @exception SQLException If an error occurs.
  85:    */
     void setNull(int index, int sqlType) throws SQLException;
   
     /**
  :    * This method sets the specified parameter from the given Java
  90:    * <code>boolean</code> value.
  91:    *
  92:    * @param index The index of the parameter value to set.
  93:    * @param value The value of the parameter.
  94:    * @exception SQLException If an error occurs.
  95:    */
     void setBoolean(int index, boolean value) throws SQLException;
   
     /**
  :    * This method sets the specified parameter from the given Java
 100:    * <code>byte</code> value.
 101:    *
 102:    * @param index The index of the parameter value to set.
 103:    * @param value The value of the parameter.
 104:    * @exception SQLException If an error occurs.
 105:    */
    void setByte(int index, byte value) throws SQLException;
  
    /**
 109:    * This method sets the specified parameter from the given Java
 110:    * <code>short</code> value.
 111:    *
 112:    * @param index The index of the parameter value to set.
 113:    * @param value The value of the parameter.
 114:    * @exception SQLException If an error occurs.
 115:    */
    void setShort(int index, short value) throws SQLException;
  
    /**
 119:    * This method sets the specified parameter from the given Java
 120:    * <code>int</code> value.
 121:    *
 122:    * @param index The index of the parameter value to set.
 123:    * @param value The value of the parameter.
 124:    * @exception SQLException If an error occurs.
 125:    */
    void setInt(int index, int value) throws SQLException;
  
    /**
 129:    * This method sets the specified parameter from the given Java
 130:    * <code>long</code> value.
 131:    *
 132:    * @param index The index of the parameter value to set.
 133:    * @param value The value of the parameter.
 134:    * @exception SQLException If an error occurs.
 135:    */
    void setLong(int index, long value) throws SQLException;
  
    /**
 139:    * This method sets the specified parameter from the given Java
 140:    * <code>float</code> value.
 141:    *
 142:    * @param index The index of the parameter value to set.
 143:    * @param value The value of the parameter.
 144:    * @exception SQLException If an error occurs.
 145:    */
    void setFloat(int index, float value) throws SQLException;
  
    /**
 149:    * This method sets the specified parameter from the given Java
 150:    * <code>double</code> value.
 151:    *
 152:    * @param index The index of the parameter value to set.
 153:    * @param value The value of the parameter.
 154:    * @exception SQLException If an error occurs.
 155:    */
    void setDouble(int index, double value) throws SQLException;
  
    /**
 159:    * This method sets the specified parameter from the given Java
 160:    * <code>java.math.BigDecimal</code> value.
 161:    *
 162:    * @param index The index of the parameter value to set.
 163:    * @param value The value of the parameter.
 164:    * @exception SQLException If an error occurs.
 165:    */
    void setBigDecimal(int index, BigDecimal value) throws
        SQLException;
  
    /**
 170:    * This method sets the specified parameter from the given Java
 171:    * <code>String</code> value.
 172:    *
 173:    * @param index The index of the parameter value to set.
 174:    * @param value The value of the parameter.
 175:    * @exception SQLException If an error occurs.
 176:    */
    void setString(int index, String value) throws SQLException;
  
    /**
 180:    * This method sets the specified parameter from the given Java
 181:    * <code>byte</code> array value.
 182:    *
 183:    * @param index The index of the parameter value to set.
 184:    * @param value The value of the parameter.
 185:    * @exception SQLException If an error occurs.
 186:    */
    void setBytes(int index, byte[] value) throws SQLException;
  
    /**
 190:    * This method sets the specified parameter from the given Java
 191:    * <code>java.sql.Date</code> value.
 192:    *
 193:    * @param index The index of the parameter value to set.
 194:    * @param value The value of the parameter.
 195:    * @exception SQLException If an error occurs.
 196:    */
    void setDate(int index, Date value) throws SQLException;
  
    /**
 200:    * This method sets the specified parameter from the given Java
 201:    * <code>java.sql.Time</code> value.
 202:    *
 203:    * @param index The index of the parameter value to set.
 204:    * @param value The value of the parameter.
 205:    * @exception SQLException If an error occurs.
 206:    */
    void setTime(int index, Time value) throws SQLException;
  
    /**
 210:    * This method sets the specified parameter from the given Java
 211:    * <code>java.sql.Timestamp</code> value.
 212:    *
 213:    * @param index The index of the parameter value to set.
 214:    * @param value The value of the parameter.
 215:    * @exception SQLException If an error occurs.
 216:    */
    void setTimestamp(int index, Timestamp value)
      throws SQLException;
  
    /**
 221:    * This method sets the specified parameter from the given Java
 222:    * ASCII <code>InputStream</code> value.
 223:    *
 224:    * @param index The index of the parameter value to set.
 225:    * @param stream The stream from which the parameter value is read.
 226:    * @param count The number of bytes in the stream.
 227:    * @exception SQLException If an error occurs.
 228:    */
    void setAsciiStream(int index, InputStream stream, int count)
      throws SQLException;
  
    /**
 233:    * This method sets the specified parameter from the given Java
 234:    * Unicode UTF-8 <code>InputStream</code> value.
 235:    *
 236:    * @param index The index of the parameter value to set.
 237:    * @param stream The stream from which the parameter value is read.
 238:    * @param count The number of bytes in the stream.
 239:    * @exception SQLException If an error occurs.
 240:    * @deprecated
 241:    */
    void setUnicodeStream(int index, InputStream stream, int count)
      throws SQLException;
  
    /**
 246:    * This method sets the specified parameter from the given Java
 247:    * binary <code>InputStream</code> value.
 248:    *
 249:    * @param index The index of the parameter value to set.
 250:    * @param stream The stream from which the parameter value is read.
 251:    * @param count The number of bytes in the stream.
 252:    * @exception SQLException If an error occurs.
 253:    */
    void setBinaryStream(int index, InputStream stream, int count)
      throws SQLException;
  
    /**
 258:    * This method clears all of the input parameter that have been
 259:    * set on this statement.
 260:    *
 261:    * @exception SQLException If an error occurs.
 262:    */
    void clearParameters() throws SQLException;
  
    /**
 266:    * This method sets the specified parameter from the given Java
 267:    * <code>Object</code> value.  The specified SQL object type will be used.
 268:    *
 269:    * @param index The index of the parameter value to set.
 270:    * @param value The value of the parameter.
 271:    * @param sqlType The SQL type to use for the parameter, from 
 272:    *                <code>Types</code>
 273:    * @param scale The scale of the value, for numeric values only.
 274:    * @exception SQLException If an error occurs.
 275:    * @see Types
 276:    */
    void setObject(int index, Object value, int sqlType, int scale)
      throws SQLException;
  
    /**
 281:    * This method sets the specified parameter from the given Java
 282:    * <code>Object</code> value.  The specified SQL object type will be used.
 283:    *
 284:    * @param index The index of the parameter value to set.
 285:    * @param value The value of the parameter.
 286:    * @param sqlType The SQL type to use for the parameter, from 
 287:    *                      <code>Types</code>
 288:    * @exception SQLException If an error occurs.
 289:    * @see Types
 290:    */
    void setObject(int index, Object value, int sqlType)
      throws SQLException;
  
    /**
 295:    * This method sets the specified parameter from the given Java
 296:    * <code>Object</code> value.  The default object type to SQL type mapping
 297:    * will be used.
 298:    *
 299:    * @param index The index of the parameter value to set.
 300:    * @param value The value of the parameter.
 301:    * @exception SQLException If an error occurs.
 302:    */
    void setObject(int index, Object value) throws SQLException;
 
    /**
 306:    * This method executes a prepared SQL query.
 307:    * Some prepared statements return multiple results; the execute method
 308:    * handles these complex statements as well as the simpler form of
 309:    * statements handled by executeQuery and executeUpdate.
 310:    *
 311:    * @return The result of the SQL statement.
 312:    * @exception SQLException If an error occurs.
 313:    */
    boolean execute() throws SQLException;
  
    /**
 317:    * This method adds a set of parameters to the batch for JDBC 2.0.
 318:    * @exception SQLException If an error occurs.
 319:    */
    void addBatch() throws SQLException;
    /**
 323:    * This method sets the specified parameter from the given Java
 324:    * character <code>Reader</code> value.
 325:    *
 326:    * @param index The index of the parameter value to set.
 327:    * @param reader The reader from which the parameter value is read.
 328:    * @param count The number of characters in the stream.
 329:    * @exception SQLException If an error occurs.
 330:    */
    void setCharacterStream(int index, Reader reader, int count)
    throws SQLException;
 
    /**
 335:    * This method sets the specified parameter from the given Java
 336:    * <code>Ref</code> value.  The default object type to SQL type mapping
 337:    * will be used.
 338:    *
 339:    * @param index The index of the parameter value to set.
 340:    * @param value The <code>Ref</code> used to set the value of the parameter.
 341:    * @exception SQLException If an error occurs.
 342:    */
    void setRef(int index, Ref value) throws SQLException;
  
    /**
 346:    * This method sets the specified parameter from the given Java
 347:    * <code>Blob</code> value.  The default object type to SQL type mapping
 348:    * will be used.
 349:    *
 350:    * @param index The index of the parameter value to set.
 351:    * @param value The <code>Blob</code> used to set the 
 352:    *             value of the parameter.
 353:    * @exception SQLException If an error occurs.
 354:    */
    void setBlob(int index, Blob value) throws SQLException;
  
    /**
 358:    * This method sets the specified parameter from the given Java
 359:    * <code>Clob</code> value.  The default object type to SQL type mapping
 360:    * will be used.
 361:    *
 362:    * @param index The index of the parameter value to set.
 363:    * @param value The <code>Clob</code> used to set the
 364:    *              value of the parameter.
 365:    * @exception SQLException If an error occurs.
 366:    */
    void setClob(int index, Clob value) throws SQLException;
  
    /**
 370:    * This method sets the specified parameter from the given Java
 371:    * <code>Array</code> value.  The default object type to SQL type mapping
 372:    * will be used.
 373:    *
 374:    * @param index The index of the parameter value to set.
 375:    * @param value The value of the parameter.
 376:    * @exception SQLException If an error occurs.
 377:    */
    void setArray(int index, Array value) throws SQLException;
  
    /**
 381:    * This method returns meta data for the result set from this statement.
 382:    *
 383:    * @return Meta data for the result set from this statement.
 384:    * @exception SQLException If an error occurs.
 385:    */
    ResultSetMetaData getMetaData() throws SQLException;
  
    /**
 389:    * This method sets the specified parameter from the given Java
 390:    * <code>java.sql.Date</code> value.
 391:    *
 392:    * @param index The index of the parameter value to set.
 393:    * @param value The value of the parameter.
 394:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 395:    * @exception SQLException If an error occurs.
 396:    */
    void setDate(int index, Date value, Calendar cal)
      throws SQLException;
  
    /**
 401:    * This method sets the specified parameter from the given Java
 402:    * <code>java.sql.Time</code> value.
 403:    *
 404:    * @param index The index of the parameter value to set.
 405:    * @param value The value of the parameter.
 406:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 407:    * @exception SQLException If an error occurs.
 408:    */
    void setTime(int index, Time value, Calendar cal)
      throws SQLException;
  
    /**
 413:    * This method sets the specified parameter from the given Java
 414:    * <code>java.sql.Timestamp</code> value.
 415:    *
 416:    * @param index The index of the parameter value to set.
 417:    * @param value The value of the parameter.
 418:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 419:    * @exception SQLException If an error occurs.
 420:    */
    void setTimestamp(int index, Timestamp value, Calendar cal)
      throws SQLException;
  
    /**
 425:    * This method populates the specified parameter with a SQL NULL value
 426:    * for the specified type.
 427:    *
 428:    * @param index The index of the parameter to set.
 429:    * @param sqlType The SQL type identifier of the parameter from
 430:    *                <code>Types</code>
 431:    * @param typeName The name of the data type, for user defined types.
 432:    * @exception SQLException If an error occurs.
 433:    */
    void setNull(int index, int sqlType, String typeName)
     throws SQLException;
  
    /**
 438:    * This method sets the specified parameter from the given Java
 439:    * <code>java.net.URL</code> value.
 440:    * 
 441:    * @param index The index of the parameter to set.
 442:    * @param value The value of the parameter.
 443:    * @exception SQLException If an error occurs.
 444:    * @since 1.4
 445:    */
    void setURL(int index, URL value) throws SQLException;
  
   /**
 449:    * Returns information about the parameters set on this 
 450:    * <code>PreparedStatement</code> (see {@link ParameterMetaData} for a
 451:    * detailed description of the provided information).
 452:    * 
 453:    * @return Meta data for the parameters of this statement.
 454:    * @see ParameterMetaData
 455:    * @since 1.4
 456:    */
    ParameterMetaData getParameterMetaData() throws SQLException;
  }
