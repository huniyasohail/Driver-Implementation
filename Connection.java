/* Connection.java -- Manage a database connection.
   2:    Copyright (C) 1999, 2000, 2002, 2006 Free Software Foundation, Inc.
   3: 
   4: This file is part of GNU Classpath.
   5: 
   6: GNU Classpath is free software; you can redistribute it and/or modify
   7: it under the terms of the GNU General Public License as published by
   8: the Free Software Foundation; either version 2, or (at your option)
   9: any later version.
  10:  
  11: GNU Classpath is distributed in the hope that it will be useful, but
  12: WITHOUT ANY WARRANTY; without even the implied warranty of
  13: MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  14: General Public License for more details.
  15: 
  16: You should have received a copy of the GNU General Public License
  17: along with GNU Classpath; see the file COPYING.  If not, write to the
  18: Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
  19: 02110-1301 USA.
  20: 
  21: Linking this library statically or dynamically with other modules is
  22: making a combined work based on this library.  Thus, the terms and
  23: conditions of the GNU General Public License cover the whole
  24: combination.
  25: 
  26: As a special exception, the copyright holders of this library give you
  27: permission to link this library with independent modules to produce an
  28: executable, regardless of the license terms of these independent
  29: modules, and to copy and distribute the resulting executable under
  30: terms of your choice, provided that you also meet, for each linked
  31: independent module, the terms and conditions of the license of that
  32: module.  An independent module is a module which is not derived from
  33: or based on this library.  If you modify this library, you may extend
  34: this exception to your version of the library, but you are not
  35: obligated to do so.  If you do not wish to do so, delete this
  36: exception statement from your version. */
   package java.sql.start;
   
   import java.util.Map;
   
   /**
  44:  * This interface provides methods for managing a connection to a database.
  45:  *
  46:  * @author Aaron M. Renn (arenn@urbanophile.com)
  47:  */
   public interface Connection 
   {
     /**
  51:    * This transaction isolation level indicates that transactions are not
  52:    * supported.
  53:    */
     int TRANSACTION_NONE = 0;
   
     /**
  57:    * This transaction isolation level indicates that one transaction can
  58:    * read modifications by other transactions before the other transactions
  59:    * have committed their changes.  This could result in invalid reads.
  60:    */
     int TRANSACTION_READ_UNCOMMITTED = 1;
   
     /**
  64:    * This transaction isolation level indicates that only committed data from
  65:    * other transactions will be read.  If a transaction reads a row, then
  66:    * another transaction commits a change to that row, the first transaction
  67:    * would retrieve the changed row on subsequent reads of the same row.
  68:    */
     int TRANSACTION_READ_COMMITTED = 2;
   
     /**
  72:    * This transaction isolation level indicates that only committed data from
  73:    * other transactions will be read.  It also ensures that data read from
  74:    * a row will not be different on a subsequent read even if another
  75:    * transaction commits a change.
  76:    */
     int TRANSACTION_REPEATABLE_READ = 4;
   
     /**
  80:    * This transaction isolation level indicates that only committed data from
  81:    * other transactions will be read.  It also ensures that data read from
  82:    * a row will not be different on a subsequent read even if another
  83:    * transaction commits a change.  Additionally, rows modified by other
  84:    * transactions will not affect the result set returned during subsequent
  85:    * executions of the same WHERE clause in this transaction.
  86:    */
     int TRANSACTION_SERIALIZABLE = 8;
   
     /**
  90:    * This method creates a new SQL statement.  The default result set type
  91:    * and concurrency will be used.
  92:    *
  93:    * @return A new <code>Statement</code> object. 
  94:    * @exception SQLException If an error occurs.
  95:    * @see Statement
  96:    */
     Statement createStatement() throws SQLException;
   
     /**
 100:    * This method creates a new <code>PreparedStatement</code> for the specified
 101:    * SQL string.  This method is designed for use with parameterized
 102:    * statements.  The default result set type and concurrency will be used.
 103:    *
 104:    * @param sql The SQL statement to use in creating this 
 105:    *            <code>PreparedStatement</code>.
 106:    * @return A new <code>PreparedStatement</code>.
 107:    * @exception SQLException If an error occurs.
 108:    * @see PreparedStatement
 109:    */
    PreparedStatement prepareStatement(String sql) throws SQLException;
  
    /**
 113:    * This method creates a new <code>CallableStatement</code> for the 
 114:    * specified SQL string.  Thie method is designed to be used with
 115:    * stored procedures.  The default result set type and concurrency
 116:    * will be used.
 117:    *
 118:    * @param sql The SQL statement to use in creating this 
 119:    *            <code>CallableStatement</code>.
 120:    * @return A new <code>CallableStatement</code>.
 121:    * @exception SQLException If an error occurs.
 122:    * @see CallableStatement
 123:    */
    CallableStatement prepareCall(String sql) throws SQLException;
  
    /**
 127:    * This method converts the specified generic SQL statement into the
 128:    * native grammer of the database this object is connected to.
 129:    *
 130:    * @param sql The JDBC generic SQL statement.
 131:    * @return The native SQL statement.
 132:    * @exception SQLException If an error occurs.
 133:    */
    String nativeSQL(String sql) throws SQLException;
  
    /**
 137:    * This method turns auto commit mode on or off.  In auto commit mode,
 138:    * every SQL statement is committed its own transaction.  Otherwise a
 139:    * transaction must be explicitly committed or rolled back.
 140:    *
 141:    * @param autoCommit <code>true</code> to enable auto commit mode,
 142:    *                   <code>false</code> to disable it.
 143:    * @exception SQLException If an error occurs.
 144:    * @see #commit()
 145:    * @see #rollback()
 146:    */
    void setAutoCommit(boolean autoCommit) throws SQLException;
  
    /**
 50:    * This method tests whether or not auto commit mode is currently enabled.
 151:    * In auto commit mode,  every SQL statement is committed its own transaction.
 152:    * Otherwise a transaction must be explicitly committed or rolled back.
 153:    *
 154:    * @return <code>true</code> if auto commit mode is enabled, 
 155:    *         <code>false</code> otherwise.
 156:    * @exception SQLException If an error occurs.
 157:    * @see #commit()
 158:    * @see #rollback()
 159:    */
    boolean getAutoCommit() throws SQLException;
  
   /**
 163:   * This method commits any SQL statements executed on this connection since 
 164:   * the last commit or rollback.
 165:   *
 166:   * @exception SQLException If an error occurs.
 167:   */
    void commit() throws SQLException;
  
    /**
 171:    * This method rolls back any SQL statements executed on this connection
 172:    * since the last commit or rollback.
 173:    *
 174:    * @exception SQLException If an error occurs.
 175:    */
    void rollback() throws SQLException;
  
    /**
 179:    * This method immediately closes this database connection.
 180:    *
 181:    * @exception SQLException If an error occurs.
 182:    */
    void close() throws SQLException;
  
    /**
 186:    * This method tests whether or not this connection has been closed. 
 187:    *
 188:    * @return <code>true</code> if the connection is closed, <code>false</code>
 189:    *         otherwise.
 190:    * @exception SQLException If an error occurs.
 191:    */
    boolean isClosed() throws SQLException;
  
    /**
 95:    * This method returns the meta data for this database connection.
 196:    *
 197:    * @return The meta data for this database.
 198:    * @exception SQLException If an error occurs.
 199:    * @see DatabaseMetaData
 200:    */
    DatabaseMetaData getMetaData() throws SQLException;
  
    /**
 204:    * This method turns read only mode on or off.  It may not be called while
 205:    * a transaction is in progress.
 206:    *
 207:    * @param readOnly <code>true</code> if this connection is read only,
 208:    *                 <code>false</code> otherwise.
 209:    * @exception SQLException If an error occurs.
 210:    */
    void setReadOnly(boolean readOnly) throws SQLException;
  
    /**
 4:    * This method tests whether or not this connection is in read only mode.
 215:    *
 216:    * @return <code>true</code> if the connection is read only <code>false</code>
 217:    *         otherwise.
 218:    * @exception SQLException If an error occurs.
 219:    */
    boolean isReadOnly() throws SQLException;
  
    /**
 223:    * This method sets the name of the catalog in use by this connection.
 224:    * Note that this method does nothing if catalogs are not supported by
 225:    * this database.
 226:    *
 227:    * @param catalog The name of the catalog to use for this connection.
 228:    * @exception SQLException If an error occurs.
 229:    */
    void setCatalog(String catalog) throws SQLException;
  
    /**
 233:    * This method returns the name of the catalog in use by this connection,
 234:    * if any.
 235:    *
 236:    * @return The name of the catalog, or <code>null</code> if none 
 237:    *         exists or catalogs are not supported by this database.
 238:    * @exception SQLException If an error occurs.
 239:    */
    String getCatalog() throws SQLException;
  
    /**
 243:    * This method sets the current transaction isolation mode.  This must
 244:    * be one of the constants defined in this interface.
 245:    *
 246:    * @param level The transaction isolation level.
 247:    * @exception SQLException If an error occurs.
 248:    */
    void setTransactionIsolation(int level) throws SQLException;
  
    /**
 252:    * This method returns the current transaction isolation mode.  This will
 253:    * be one of the constants defined in this interface.
 254:    *
 255:    * @return The transaction isolation level.
 256:    * @exception SQLException If an error occurs.
 257:    */
    int getTransactionIsolation() throws SQLException;
  
    /**
 261:    * This method returns the first warning that occurred on this connection,
 262:    * if any.  If there were any subsequence warnings, they will be chained
 263:    * to the first one.
 264:    *
 265:    * @return The first <code>SQLWarning</code> that occurred, or 
 266:    *         <code>null</code> if there have been no warnings.
 267:    * @exception SQLException If an error occurs.
 268:    */
    SQLWarning getWarnings() throws SQLException;
  
    /**
 272:    * This method clears all warnings that have occurred on this connection.
 273:    *
 274:    * @exception SQLException If an error occurs.
 275:    */
    void clearWarnings() throws SQLException;
  
    /**
 279:    * This method creates a new SQL statement with the specified type and
 280:    * concurrency.  Valid values for these parameters are specified in the
 281:    * <code>ResultSet</code> class.
 282:    *
 283:    * @param resultSetType The type of result set to use for this statement.
 284:    * @param resultSetConcurrency  The type of concurrency to be used in
 285:    *                              the result set for this statement.
 286:    * @return A new <code>Statement</code> object.
 287:    * @exception SQLException If an error occurs.
 288:    * @see Statement
 289:    * @see ResultSet
 290:    */
    Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException;
  
    /**
 295:    * This method creates a new <code>PreparedStatement</code> for the specified
 296:    * SQL string.  This method is designed for use with parameterized
 297:    * statements.  The specified result set type and concurrency will be used.
 298:    * Valid values for these parameters are specified in the
 299:    * <code>ResultSet</code> class.
 300:    *
 301:    * @param sql The SQL statement to use in creating this 
 302:    *            <code>PreparedStatement</code>.
 303:    * @param resultSetType The type of result set to use for this statement.
 304:    * @param resultSetConcurrency  The type of concurrency to be used in
 305:    *                              the result set for this statement.
 306:    * @return A new <code>PreparedStatement</code>.
 307:    * @exception SQLException If an error occurs.
 308:    * @see PreparedStatement
 309:    * @see ResultSet
 310:    */
    PreparedStatement prepareStatement(String sql, int resultSetType, 
      int resultSetConcurrency) throws SQLException;
  
    /**
 315:    * This method creates a new <code>CallableStatement</code> for the 
 316:    * specified SQL string.  Thie method is designed to be used with
 317:    * stored procedures.  The specified result set type and concurrency
 318:    * will be used.  Valid values for these parameters are specified in the
 319:    * <code>ResultSet</code> class.
 320:    *
 321:    * @param sql The SQL statement to use in creating this 
 322:    *            <code>PreparedStatement</code>.
 323:    * @param resultSetType The type of result set to use for this statement.
 324:    * @param resultSetConcurrency  The type of concurrency to be used in
 325:    *                              the result set for this statement.
 326:    * @return A new <code>CallableStatement</code>.
 327:    * @exception SQLException If an error occurs.
 328:    * @see CallableStatement
 329:    * @see ResultSet
 330:    */
    CallableStatement prepareCall(String sql, int resultSetType, int
      resultSetConcurrency) throws SQLException;
  
    /**
 335:    * This method returns the mapping of SQL types to Java classes
 336:    * currently in use by this connection.  This mapping will have no
 337:    * entries unless they have been manually added.
 338:    *
 339:    * @return The SQL type to Java class mapping.
 340:    * @exception SQLException If an error occurs.
 341:    */
    Map<String, Class<?>> getTypeMap() throws SQLException;
 
    /**
 345:    * This method sets the mapping table for SQL types to Java classes.
 346:    * Any entries in this map override the defaults.
 347:    *
 348:    * @param map The new SQL mapping table.
 349:    * @exception SQLException If an error occurs.
 350:    */
    void setTypeMap(Map<String, Class<?>> map) throws SQLException;
  
    /**
 354:    * Sets the default holdability of <code>ResultSet</code>S that are created
 355:    * from <code>Statement</code>S using this <code>Connection</code>.
 356:    * 
 357:    * @param holdability The default holdability value to set, this must be one
 358:    *                    of <code>ResultSet.HOLD_CURSORS_OVER_COMMIT</code> or
 359:    *                    <code>ResultSet.CLOSE_CURSORS_AT_COMMIT</code>.
 360:    * @exception SQLException If an error occurs.
 361:    * @see ResultSet
 362:    * @since 1.4
 363:    */
    void setHoldability(int holdability) throws SQLException;
  
    /**
 367:    * Gets the default holdability of <code>ResultSet</code>S that are created
 368:    * from <code>Statement</code>S using this <code>Connection</code>.
 369:    * 
 370:    * @return The current default holdability value, this must be one of
 371:    *          <code>ResultSet.HOLD_CURSORS_OVER_COMMIT</code> or
 372:    *          <code>ResultSet.CLOSE_CURSORS_AT_COMMIT</code>.
 373:    * @exception SQLException If an error occurs.
 374:    * @see ResultSet
 375:    * @since 1.4
 376:    */
    int getHoldability() throws SQLException;
  
    /**
 380:    * Creates a new unnamed savepoint for this <code>Connection</code>
 381:    * 
 382:    * @return The <code>Savepoint</code> object representing the savepoint.
 383:    * @exception SQLException If an error occurs.
 384:    * @since 1.4
 385:    */
    Savepoint setSavepoint() throws SQLException;
  
    /**
 389:    * Creates a new savepoint with the specifiend name for this
 390:    * <code>Connection</code>.
 391:    * 
 392:    * @param name The name of the savepoint.
 393:    * @return The <code>Savepoint</code> object representing the savepoint.
 394:    * @exception SQLException If an error occurs.
 395:    * @since 1.4
 396:    */
    Savepoint setSavepoint(String name) throws SQLException;
  
    /**
 400:    * Undoes all changes made after the specified savepoint was set.
 401:    * 
 402:    * @param savepoint The safepoint to roll back to.
 403:    * @exception SQLException If an error occurs.
 404:    * @since 1.4
 405:    */
    void rollback(Savepoint savepoint) throws SQLException;
  
    /**
 409:    * Removes the specified savepoint from this <code>Connection</code>.
 410:    * Refering to a savepoint after it was removed is an error and will throw an
 411:    * SQLException.
 412:    * 
 413:    * @param savepoint The savepoint to release.
 414:    * @exception SQLException If an error occurs.
 415:    * @since 1.4
 416:    */
    void releaseSavepoint(Savepoint savepoint) throws SQLException;
  
    /**
 420:    * This method creates a new SQL statement with the specified type,
 421:    * concurrency and holdability, instead of using the defaults.  Valid values
 422:    * for these parameters are specified in the <code>ResultSet</code> class.
 423:    * 
 424:    * @param resultSetType The type of result set to use for this statement.
 425:    * @param resultSetConcurrency The type of concurrency to be used in
 426:    *                             the result set for this statement.
 427:    * @param resultSetHoldability The type of holdability to be usd in the
 428:    *                             result set for this statement.
 429:    * @return A new <code>Statement</code>
 430:    * @exception SQLException If an error occurs.
 431:    * @see ResultSet
 432:    * @since 1.4
 433:    */
    Statement createStatement(int resultSetType, int
        resultSetConcurrency, int resultSetHoldability) throws SQLException;
     /**
 438:    * This method creates a new <code>PreparedStatement</code> for the specified
 439:    * SQL string.  This method is designed for use with parameterized
 440:    * statements.  The specified result set type, concurrency and holdability
 441:    * will be used. Valid values for these parameters are specified in the
 442:    * <code>ResultSet</code> class.
 443:    *
 444:    * @param sql The SQL statement to use in creating this 
 445:    *            <code>PreparedStatement</code>.
 446:    * @param resultSetType The type of result set to use for this statement.
 447:    * @param resultSetConcurrency The type of concurrency to be used in
 448:    *                             the result set for this statement.
 449:    * @param resultSetHoldability The type of holdability to be usd in the
 450:    *                             result set for this statement.
 451:    * @return A new <code>PreparedStatement</code>.
 452:    * @exception SQLException If an error occurs.
 453:    * @see PreparedStatement
 454:    * @see ResultSet
 455:    * @since 1.4
 456:    */
    PreparedStatement prepareStatement(String sql, int resultSetType, int
        resultSetConcurrency, int resultSetHoldability) throws SQLException;
  
    /**
 461:    * This method creates a new <code>CallableStatement</code> for the 
 462:    * specified SQL string.  Thie method is designed to be used with
 463:    * stored procedures.  The specified result set type, concurrency and
 464:    * holdability will be used.  Valid values for these parameters are specified
 465:    * in the <code>ResultSet</code> class.
 466:    *
 467:    * @param sql The SQL statement to use in creating this 
 468:    *            <code>PreparedStatement</code>.
 469:    * @param resultSetType The type of result set to use for this statement.
 470:    * @param resultSetConcurrency The type of concurrency to be used in
 471:    *                             the result set for this statement.
 472:    * @param resultSetHoldability The type of holdability to be used in the
 473:    *                             result set for this statement.
 474:    * @return A new <code>CallableStatement</code>.
 475:    * @exception SQLException If an error occurs.
 476:    * @see CallableStatement
 477:    * @see ResultSet
 478:    * @since 1.4
 479:    */
    CallableStatement prepareCall(String sql, int resultSetType, int
        resultSetConcurrency, int resultSetHoldability) throws SQLException;
  
    /**
 484:    * @since 1.4
 485:    */
    PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
        throws SQLException;
  
    /**
 490:    * @since 1.4
 491:    */
    PreparedStatement prepareStatement(String sql, int[] columnIndexes)
        throws SQLException;
  
    /**
 496:    * @since 1.4
 497:    */
    PreparedStatement prepareStatement(String sql, String[] columnNames)
        throws SQLException;
  }
