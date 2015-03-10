package java.sql.start;
   
   import java.io.InputStream;
   import java.io.Reader;
   import java.math.BigDecimal;
   import java.net.URL;
   import java.util.Calendar;
   import java.util.Map;
   
   /**
  49:  * This interface provides access to the data set returned by a SQL
  50:  * statement.  An instance of this interface is returned by the various
  51:  * execution methods in the <code>Statement</code>.
  52:  *
  53:  * <p> This class models a cursor, which can be stepped through one row at a
  54:  * time.  Methods are provided for accessing columns by column name or by
  55:  * index.</p>
  56:  *
  57:  * <p> Note that a result set is invalidated if the statement that returned
  58:  * it is closed.</p>
  59:  *
  60:  * @author Aaron M. Renn (arenn@urbanophile.com)
  61:  */
   public interface ResultSet 
   {
     /**
  :    * The rows will be processed in order from first to last.
  66:    */
     int FETCH_FORWARD = 1000;
   
     /**
  70:    * The rows will be processed in order from last to first.
  71:    */
     int FETCH_REVERSE = 1001;
   
     /**
  75:    * The rows will be processed in an unknown order
  76:    */
     int FETCH_UNKNOWN = 1002;
   
     /**
  80:    * This type of result set may only step forward through the rows returned.
  81:    */
     int TYPE_FORWARD_ONLY = 1003;
   
     /**
  85:    * This type of result set is scrollable and is not sensitive to changes
  86:    * made by other statements.
  87:    */
     int TYPE_SCROLL_INSENSITIVE = 1004;
   
     /**
  91:    * This type of result set is scrollable and is also sensitive to changes
  92:    * made by other statements.
  93:    */
     int TYPE_SCROLL_SENSITIVE = 1005;
   
     /**
  97:    * The concurrency mode of for the result set may not be modified.
  98:    */
     int CONCUR_READ_ONLY = 1007;
  
    /**
 02:    * The concurrency mode of for the result set may be modified.
 103:    */
    int CONCUR_UPDATABLE = 1008;
  
    int HOLD_CURSORS_OVER_COMMIT = 1;
  
    int CLOSE_CURSORS_AT_COMMIT = 2;
  
    /**
 1:    * This method advances to the next row in the result set.  Any streams
 112:    * open on the current row are closed automatically.
 113:    *
 114:    * @return <code>true</code> if the next row exists, <code>false</code>
 115:    *         otherwise.
 116:    * @exception SQLException If an error occurs.
 117:    */
    boolean next() throws SQLException;
  
    /**
 1:    * This method closes the result set and frees any associated resources.
 122:    * 
 123:    * @exception SQLException If an error occurs.
 124:    */
    void close() throws SQLException;
  
    /**
 28:    * This method tests whether the value of the last column that was fetched
 129:    * was actually a SQL NULL value.
 130:    *
 131:    * @return <code>true</code> if the last column fetched was a NULL,
 132:    *         <code>false</code> otherwise.
 133:    * @exception SQLException If an error occurs.
 134:    */
    boolean wasNull() throws SQLException;
  
    /**
 8:    * This method returns the value of the specified column as a Java
 139:    * <code>String</code>.
 140:    *
 141:    * @param columnIndex The index of the column to return.
 142:    * @return The column value as a <code>String</code>.
 143:    * @exception SQLException If an error occurs.
 144:    */
    String getString(int columnIndex) throws SQLException;
  
    /**
 8:    * This method returns the value of the specified column as a Java
 149:    * <code>boolean</code>.
 150:    *
 151:    * @param columnIndex The index of the column to return.
 152:    * @return The column value as a <code>boolean</code>.
 153:    * @exception SQLException If an error occurs.
 154:    */
    boolean getBoolean(int columnIndex) throws SQLException;
  
    /**
 58:    * This method returns the value of the specified column as a Java
 159:    * <code>byte</code>.
 160:    *
 161:    * @param columnIndex The index of the column to return.
 162:    * @return The column value as a <code>byte</code>.
 163:    * @exception SQLException If an error occurs.
 164:    */
    byte getByte(int columnIndex) throws SQLException;
  
    /**
 168:    * This method returns the value of the specified column as a Java
 169:    * <code>short</code>.
 170:    *
 171:    * @param columnIndex The index of the column to return.
 172:    * @return The column value as a <code>short</code>.
 173:    * @exception SQLException If an error occurs.
 174:    */
    short getShort(int columnIndex) throws SQLException;
  
    /**
 178:    * This method returns the value of the specified column as a Java
 179:    * <code>int</code>.
 180:    *
 181:    * @param columnIndex The index of the column to return.
 182:    * @return The column value as a <code>int</code>.
 183:    * @exception SQLException If an error occurs.
 184:    */
    int getInt(int columnIndex) throws SQLException;
  
    /**
 188:    * This method returns the value of the specified column as a Java
 189:    * <code>long</code>.
 190:    *
 191:    * @param columnIndex The index of the column to return.
 192:    * @return The column value as a <code>long</code>.
 193:    * @exception SQLException If an error occurs.
 194:    */
    long getLong(int columnIndex) throws SQLException;
  
    /**
 198:    * This method returns the value of the specified column as a Java
 199:    * <code>float</code>.
 200:    *
 201:    * @param columnIndex The index of the column to return.
 202:    * @return The column value as a <code>float</code>.
 203:    * @exception SQLException If an error occurs.
 204:    */
    float getFloat(int columnIndex) throws SQLException;
  
    /**
 208:    * This method returns the value of the specified column as a Java
 209:    * <code>double</code>.
 210:    *
 211:    * @param columnIndex The index of the column to return.
 212:    * @return The column value as a <code>double</code>.
 213:    * @exception SQLException If an error occurs.
 214:    */
    double getDouble(int columnIndex) throws SQLException;
  
    /**
 218:    * This method returns the value of the specified column as a Java
 219:    * <code>BigDecimal</code>.
 220:    *
 221:    * @param columnIndex The index of the column to return.
 222:    * @param scale The number of digits to the right of the decimal to return.
 223:    * @return The column value as a <code>BigDecimal</code>.
 224:    * @exception SQLException If an error occurs.
 225:    * @deprecated
 226:    */
    BigDecimal getBigDecimal(int columnIndex, int scale)
      throws SQLException;
  
    /**
 231:    * This method returns the value of the specified column as a Java
 232:    * byte array.
 233:    *
 234:    * @param columnIndex The index of the column to return.
 235:    * @return The column value as a byte array
 236:    * @exception SQLException If an error occurs.
 237:    */
    byte[] getBytes(int columnIndex) throws SQLException;
  
    /**
 241:    * This method returns the value of the specified column as a Java
 242:    * <code>java.sql.Date</code>.
 243:    *
 244:    * @param columnIndex The index of the column to return.
 245:    * @return The column value as a <code>java.sql.Date</code>.
 246:    * @exception SQLException If an error occurs.
 247:    */
    Date getDate(int columnIndex) throws SQLException;
  
    /**
 251:    * This method returns the value of the specified column as a Java
 252:    * <code>java.sql.Time</code>.
 253:    *
 254:    * @param columnIndex The index of the column to return.
 255:    * @return The column value as a <code>java.sql.Time</code>.
 256:    * @exception SQLException If an error occurs.
 257:    */
    Time getTime(int columnIndex) throws SQLException;
  
    /**
 261:    * This method returns the value of the specified column as a Java
 262:    * <code>java.sql.Timestamp</code>.
 263:    *
 264:    * @param columnIndex The index of the column to return.
 265:    * @return The column value as a <code>java.sql.Timestamp</code>.
 266:    * @exception SQLException If an error occurs.
 267:    */
   Timestamp getTimestamp(int columnIndex) throws SQLException;
 
    /**
 271:    * This method returns the value of the specified column as an ASCII 
 272:    * stream.  Note that all the data from this stream must be read before
 273:    * fetching the value of any other column.  Please also be aware that 
 274:    * calling <code>next()</code> or <code>close()</code> on this result set
 275:    * will close this stream as well.
 276:    *
 277:    * @param columnIndex The index of the column to return.
 278:    * @return The column value as an ASCII <code>InputStream</code>.
 279:    * @exception SQLException If an error occurs.
 280:    */
    InputStream getAsciiStream(int columnIndex) throws SQLException;
  
    /**
 284:    * This method returns the value of the specified column as a Unicode UTF-8
 285:    * stream.  Note that all the data from this stream must be read before
 286:    * fetching the value of any other column.  Please also be aware that 
 287:    * calling <code>next()</code> or <code>close()</code> on this result set
 288:    * will close this stream as well.
 289:    *
 290:    * @param columnIndex The index of the column to return.
 291:    * @return The column value as a Unicode UTF-8 <code>InputStream</code>.
 292:    * @exception SQLException If an error occurs.
 293:    * @deprecated Use getCharacterStream instead.
 294:    */
    InputStream getUnicodeStream(int columnIndex) throws SQLException;
  
    /**
 98:    * This method returns the value of the specified column as a raw byte
 299:    * stream.  Note that all the data from this stream must be read before
 300:    * fetching the value of any other column.  Please also be aware that 
 301:    * calling <code>next()</code> or <code>close()</code> on this result set
 302:    * will close this stream as well.
 303:    *
 304:    * @param columnIndex The index of the column to return.
 305:    * @return The column value as a raw byte <code>InputStream</code>.
 306:    * @exception SQLException If an error occurs.
 307:    */
    InputStream getBinaryStream(int columnIndex) throws SQLException;
  
    /**
 311:    * This method returns the value of the specified column as a Java
 312:    * <code>String</code>.
 313:    *
 314:    * @param columnName The name of the column to return.
 315:    * @return The column value as a <code>String</code>.
 316:    * @exception SQLException If an error occurs.
 317:    */
    String getString(String columnName) throws SQLException;
  
    /**
 321:    * This method returns the value of the specified column as a Java
 322:    * <code>boolean</code>.
 323:    *
 324:    * @param columnName The name of the column to return.
 325:    * @return The column value as a <code>boolean</code>.
 326:    * @exception SQLException If an error occurs.
 327:    */
    boolean getBoolean(String columnName) throws SQLException;
  
    /**
 331:    * This method returns the value of the specified column as a Java
 332:    * <code>byte</code>.
 333:    *
 334:    * @param columnName The name of the column to return.
 335:    * @return The column value as a <code>byte</code>.
 336:    * @exception SQLException If an error occurs.
 337:    */
    byte getByte(String columnName) throws SQLException;
  
    /**
 341:    * This method returns the value of the specified column as a Java
 342:    * <code>short</code>.
 343:    *
 344:    * @param columnName The name of the column to return.
 345:    * @return The column value as a <code>short</code>.
 346:    * @exception SQLException If an error occurs.
 347:    */
    short getShort(String columnName) throws SQLException;
  
    /**
 351:    * This method returns the value of the specified column as a Java
 352:    * <code>int</code>.
 353:    *
 354:    * @param columnName The name of the column to return.
 355:    * @return The column value as a <code>int</code>.
 356:    * @exception SQLException If an error occurs.
 357:    */
    int getInt(String columnName) throws SQLException;
  
    /**
 361:    * This method returns the value of the specified column as a Java
 362:    * <code>long</code>.
 363:    *
 364:    * @param columnName The name of the column to return.
 365:    * @return The column value as a <code>long</code>.
 366:    * @exception SQLException If an error occurs.
 367:    */
    long getLong(String columnName) throws SQLException;
  
    /**
 371:    * This method returns the value of the specified column as a Java
 372:    * <code>float</code>.
 373:    *
 374:    * @param columnName The name of the column to return.
 375:    * @return The column value as a <code>float</code>.
 376:    * @exception SQLException If an error occurs.
 377:    */
    float getFloat(String columnName) throws SQLException;
  
    /**
 381:    * This method returns the value of the specified column as a Java
 382:    * <code>double</code>.
 383:    *
 384:    * @param columnName The name of the column to return.
 385:    * @return The column value as a <code>double</code>.
 386:    * @exception SQLException If an error occurs.
 387:    */
    double getDouble(String columnName) throws SQLException;
 
    /**
 391:    * This method returns the value of the specified column as a Java
 392:    * <code>BigDecimal</code>.
 393:    *
 394:    * @param columnName The name of the column to return.
 395:    * @return The column value as a <code>BigDecimal</code>.
 396:    * @exception SQLException If an error occurs.
 397:    * @deprecated
 398:    */
    BigDecimal getBigDecimal(String columnName, int scale)
      throws SQLException;
  
    /**
 03:    * This method returns the value of the specified column as a Java
 404:    * byte array.
 405:    *
 406:    * @param columnName The name of the column to return.
 407:    * @return The column value as a byte array
 408:    * @exception SQLException If an error occurs.
 409:    */
    byte[] getBytes(String columnName) throws SQLException;
  
    /**
 413:    * This method returns the value of the specified column as a Java
 414:    * <code>java.sql.Date</code>.
 415:    *
 416:    * @param columnName The name of the column to return.
 417:    * @return The column value as a <code>java.sql.Date</code>.
 418:    * @exception SQLException If an error occurs.
 419:    */
    Date getDate(String columnName) throws SQLException;
  
    /**
 3:    * This method returns the value of the specified column as a Java
 424:    * <code>java.sql.Time</code>.
 425:    *
 426:    * @param columnName The name of the column to return.
 427:    * @return The column value as a <code>java.sql.Time</code>.
 428:    * @exception SQLException If an error occurs.
 429:    */
    Time getTime(String columnName) throws SQLException;
  
    /**
 433:    * This method returns the value of the specified column as a Java
 434:    * <code>java.sql.Timestamp</code>.
 435:    *
 436:    * @param columnName The name of the column to return.
 437:    * @return The column value as a <code>java.sql.Timestamp</code>.
 438:    * @exception SQLException If an error occurs.
 439:    */
    Timestamp getTimestamp(String columnName) throws SQLException;
  
    /**
 443:    * This method returns the value of the specified column as an ASCII 
 444:    * stream.  Note that all the data from this stream must be read before
 445:    * fetching the value of any other column.  Please also be aware that 
 446:    * calling <code>next()</code> or <code>close()</code> on this result set
 447:    * will close this stream as well.
 448:    *
 449:    * @param columnName The name of the column to return.
 450:    * @return The column value as an ASCII <code>InputStream</code>.
 451:    * @exception SQLException If an error occurs.
 452:    */
    InputStream getAsciiStream(String columnName) throws SQLException;
  
    /**
 6:    * This method returns the value of the specified column as a Unicode UTF-8
 457:    * stream.  Note that all the data from this stream must be read before
 458:    * fetching the value of any other column.  Please also be aware that 
 459:    * calling <code>next()</code> or <code>close()</code> on this result set
 460:    * will close this stream as well.
 461:    *
 462:    * @param columnName The name of the column to return.
 463:    * @return The column value as a Unicode UTF-8 <code>InputStream</code>.
 464:    * @exception SQLException If an error occurs.
 465:    * @deprecated Use getCharacterStream instead.
 466:    */
    InputStream getUnicodeStream(String columnName) throws SQLException;
  
    /**
 470:    * This method returns the value of the specified column as a raw byte
 471:    * stream.  Note that all the data from this stream must be read before
 472:    * fetching the value of any other column.  Please also be aware that 
 473:    * calling <code>next()</code> or <code>close()</code> on this result set
 474:    * will close this stream as well.
 475:    *
 476:    * @param columnName The name of the column to return.
 477:    * @return The column value as a raw byte <code>InputStream</code>.
 478:    * @exception SQLException If an error occurs.
 479:    */
    InputStream getBinaryStream(String columnName) throws SQLException;
  
    /**
 483:    * This method returns the first SQL warning associated with this result
 484:    * set.  Any additional warnings will be chained to this one.
 485:    *
 486:    * @return The first SQLWarning for this result set, or <code>null</code> if
 487:    *         there are no warnings.
 488:    * @exception SQLException If an error occurs.
 489:    */
    SQLWarning getWarnings() throws SQLException;
  
    /**
 493:    * This method clears all warnings associated with this result set.
 494:    *
 495:    * @exception SQLException If an error occurs.
 496:    */
    void clearWarnings() throws SQLException;
 
    /**
 00:    * This method returns the name of the database cursor used by this
 501:    * result set.
 502:    *
 503:    * @return The name of the database cursor used by this result set.
 504:    * @exception SQLException If an error occurs.
 :    */
    String getCursorName() throws SQLException;
  
    /**
 509:    * This method returns data about the columns returned as part of the
 510:    * result set as a <code>ResultSetMetaData</code> instance.
 511:    *
 512:    * @return The <code>ResultSetMetaData</code> instance for this result set.
 513:    * @exception SQLException If an error occurs.
 514:    */
    ResultSetMetaData getMetaData() throws SQLException;
  
    /**
 518:    * This method returns the value of the specified column as a Java
 519:    * <code>Object</code>.
 520:    *
 521:    * @param columnIndex The index of the column to return.
 522:    * @return The column value as an <code>Object</code>.
 523:    * @exception SQLException If an error occurs.
 524:    */
    Object getObject(int columnIndex) throws SQLException;
 
    /**
 528:    * This method returns the value of the specified column as a Java
 529:    * <code>Object</code>.
 530:    *
 531:    * @param columnName The name of the column to return.
 532:    * @return The column value as an <code>Object</code>.
 533:    * @exception SQLException If an error occurs.
 534:    */
    Object getObject(String columnName) throws SQLException;
  
    /**
 538:    * This method returns the column index of the specified named column.
 539:    *
 540:    * @param columnName The name of the column.
 541:    * @return The index of the column.
 542:    * @exception SQLException If an error occurs.
 543:    */
    int findColumn(String columnName) throws SQLException;
  
    /**
 547:    * This method returns the value of the specified column as a character
 548:    * stream.  Note that all the data from this stream must be read before
 549:    * fetching the value of any other column.  Please also be aware that 
 550:    * calling <code>next()</code> or <code>close()</code> on this result set
 551:    * will close this stream as well.
 552:    *
 553:    * @param columnIndex The index of the column to return.
 554:    * @return The column value as an character <code>Reader</code>.
 555:    * @exception SQLException If an error occurs.
 556:    */
    Reader getCharacterStream(int columnIndex) throws SQLException;
  
    /**
 560:    * This method returns the value of the specified column as a character
 561:    * stream.  Note that all the data from this stream must be read before
 562:    * fetching the value of any other column.  Please also be aware that 
 563:    * calling <code>next()</code> or <code>close()</code> on this result set
 564:    * will close this stream as well.
 565:    *
 566:    * @param columnName The name of the column to return.
 567:    * @return The column value as an character <code>Reader</code>.
 568:    * @exception SQLException If an error occurs.
 569:    */
    Reader getCharacterStream(String columnName) throws SQLException;
  
    /**
 573:    * This method returns the value of the specified column as a Java
 574:    * <code>BigDecimal</code>.
 575:    *
 576:    * @param columnIndex The index of the column to return.
 577:    * @return The column value as a <code>BigDecimal</code>.
 578:    * @exception SQLException If an error occurs.
 579:    */
    BigDecimal getBigDecimal(int columnIndex) throws SQLException;
  
    /**
 83:    * This method returns the value of the specified column as a Java
 584:    * <code>BigDecimal</code>.
 585:    *
 586:    * @param columnName The name of the column to return.
 587:    * @return The column value as a <code>BigDecimal</code>.
 588:    * @exception SQLException If an error occurs.
 589:    */
    BigDecimal getBigDecimal(String columnName) throws SQLException;
  
    /**
 593:    * This method tests whether or not the cursor is before the first row
 594:    * in the result set.
 595:    *
 596:    * @return <code>true</code> if the cursor is positioned before the first
 597:    *         row, <code>false</code> otherwise.
 598:    * @exception SQLException If an error occurs.
 599:    */
    boolean isBeforeFirst() throws SQLException;
  
    /**
 603:    * This method tests whether or not the cursor is after the last row
 604:    * in the result set.
 605:    *
 606:    * @return <code>true</code> if the cursor is positioned after the last
 607:    *         row, <code>false</code> otherwise.
 608:    * @exception SQLException If an error occurs.
 609:    */
    boolean isAfterLast() throws SQLException;
  
    /**
 613:    * This method tests whether or not the cursor is positioned on the first
 614:    * row in the result set.
 615:    *
 616:    * @return <code>true</code> if the cursor is positioned on the first
 617:    *         row, <code>false</code> otherwise.
 618:    * @exception SQLException If an error occurs.
 619:    */
    boolean isFirst() throws SQLException;
  
    /**
 623:    * This method tests whether or not the cursor is on the last row
 624:    * in the result set.
 625:    *
 626:    * @return <code>true</code> if the cursor is positioned on the last
 627:    *         row, <code>false</code> otherwise.
 628:    * @exception SQLException If an error occurs.
 629:    */
    boolean isLast() throws SQLException;
  
    /**
 633:    * This method repositions the cursor to before the first row in the
 634:    * result set.
 635:    * 
 636:    * @exception SQLException If an error occurs.
 637:    */
    void beforeFirst() throws SQLException;
  
    /**
 641:    * This method repositions the cursor to after the last row in the result
 642:    * set.
 643:    * 
 644:    * @exception SQLException If an error occurs.
 645:    */
    void afterLast() throws SQLException;
  
    /**
 649:    * This method repositions the cursor on the first row in the
 650:    * result set.
 651:    *
 652:    * @return <code>true</code> if the cursor is on a valid row;
 653:    *         <code>false</code> if there are no rows in the result set.
 654:    * @exception SQLException If an error occurs.
 655:    */
    boolean first() throws SQLException;
  
    /**
 659:    * This method repositions the cursor on the last row in the result
 660:    * set.
 661:    * 
 662:    * @return <code>true</code> if the cursor is on a valid row;
 663:    *         <code>false</code> if there are no rows in the result set.
 664:    * @exception SQLException If an error occurs.
 665:    */
    boolean last() throws SQLException;
  
    /**
 669:    * This method returns the current row number in the cursor.  Numbering
 670:    * begins at index 1.
 671:    *
 672:    * @return The current row number, or 0 if there is not current row.
 673:    * @exception SQLException If an error occurs.
 674:    */
    int getRow() throws SQLException;
  
    /**
 678:    * This method positions the result set to the specified absolute row.
 679:    * Positive numbers are row offsets from the beginning of the result
 680:    * set (numbering starts from row 1) and negative numbers are row offsets
 681:    * from the end of the result set (numbering starts from -1).
 682:    *
 683:    * @param row The row to position the result set to.
 684:    *
 685:    * @return <code>true</code> if the current position was changed,
 686:    *         <code>false</code> otherwise.
 687:    * @exception SQLException If an error occurs.
 688:    */
    boolean absolute(int row) throws SQLException;
  
    /**
 692:    * This method moves the result set position relative to the current row.
 693:    * The offset can be positive or negative.
 694:    *
 695:    * @param rows The number of row positions to move.
 696:    * @return <code>true</code> if the current position was changed,
 697:    *         <code>false</code> otherwise.
 698:    * @exception SQLException If an error occurs.
 699:    */
    boolean relative(int rows) throws SQLException;
  
    /**
 703:    * This method moves the current position to the previous row in the
 704:    * result set.
 705:    *
 706:    * @return <code>true</code> if the previous row exists, <code>false</code>
 707:    *         otherwise.
 708:    * @exception SQLException If an error occurs.
 709:    */
    boolean previous() throws SQLException;
  
    /**
 713:    * This method provides a hint to the driver about which direction the
 714:    * result set will be processed in. 
 715:    *
 716:    * @param direction The direction in which rows will be processed. The
 717:    *                  allowed values are the <code>FETCH_*</code> constants
 718:    *                  defined in this interface.
 719:    * @exception SQLException If an error occurs.
 720:    */
    void setFetchDirection(int direction) throws SQLException;
  
    /**
 724:    * This method returns the current fetch direction for this result set.
 725:    *
 726:    * @return The fetch direction for this result set.
 727:    * @exception SQLException If an error occurs.
 28:    */
    int getFetchDirection() throws SQLException;
  
    /**
 732:    * This method provides a hint to the driver about how many rows at a
 733:    * time it should fetch from the database.
 734:    *
 735:    * @param rows The number of rows the driver should fetch per call.
 736:    * @exception SQLException If an error occurs.
 737:    */
    void setFetchSize(int rows) throws SQLException;
  
    /**
 741:    * This method returns the current number of rows that will be fetched 
 742:    * from the database at a time.
 743:    *
 744:    * @return The current fetch size for this result set.
 745:    * @exception SQLException If an error occurs.
 746:    */
    int getFetchSize() throws SQLException;
  
    /**
 750:    * This method returns the result set type of this result set.  This will
 751:    * be one of the <code>TYPE_*</code> constants defined in this interface.
 752:    *
 753:    * @return The result set type.
 754:    * @exception SQLException If an error occurs.
 755:    */
    int getType() throws SQLException;
 
    /**
 59:    * This method returns the concurrency type of this result set.  This will
 760:    * be one of the <code>CONCUR_*</code> constants defined in this interface.
 761:    *
 762:    * @return The result set concurrency type.
 763:    * @exception SQLException If an error occurs.
 764:    */
    int getConcurrency() throws SQLException;
  
    /**
 768:    * This method tests whether or not the current row in the result set
 769:    * has been updated.  Updates must be visible in order of this method to
 770:    * detect the update.
 771:    *
 772:    * @return <code>true</code> if the row has been updated, <code>false</code>
 773:    *         otherwise.
 774:    * @exception SQLException If an error occurs.
 775:    */
    boolean rowUpdated() throws SQLException;
  
    /**
 779:    * This method tests whether or not the current row in the result set
 780:    * has been inserted.  Inserts must be visible in order of this method to
 781:    * detect the insert.
 782:    *
 783:    * @return <code>true</code> if the row has been inserted, <code>false</code>
 784:    *         otherwise.
 785:    * @exception SQLException If an error occurs.
 786:    */
    boolean rowInserted() throws SQLException;
  
    /**
 0:    * This method tests whether or not the current row in the result set
 791:    * has been deleted.  Deletes must be visible in order of this method to
 792:    * detect the deletion.
 793:    *
 794:    * @return <code>true</code> if the row has been deleted, <code>false</code>
 795:    *         otherwise.
 796:    * @exception SQLException If an error occurs.
 797:    */
    boolean rowDeleted() throws SQLException;
  
    /**
 801:    * This method updates the specified column to have a NULL value.  This
 802:    * does not update the actual database.  <code>updateRow</code> must be
 803:    * called in order to do that.
 804:    *
 805:    * @param columnIndex The index of the column to update.
 806:    * @exception SQLException If an error occurs.
 807:    */
    void updateNull(int columnIndex) throws SQLException;
  
    /**
 811:    * This method updates the specified column to have a boolean value.  This
 812:    * does not update the actual database.  <code>updateRow</code> must be
 813:    * called in order to do that.
 814:    *
 815:    * @param columnIndex The index of the column to update.
 816:    * @param value The new value of the column.
 817:    * @exception SQLException If an error occurs.
 818:    */
    void updateBoolean(int columnIndex, boolean value) throws SQLException;
  
    /**
 22:    * This method updates the specified column to have a byte value.  This
 823:    * does not update the actual database.  <code>updateRow</code> must be
 824:    * called in order to do that.
 825:    *
 826:    * @param columnIndex The index of the column to update.
 827:    * @param value The new value of the column.
 828:    * @exception SQLException If an error occurs.
 829:    */
    void updateByte(int columnIndex, byte value) throws SQLException;
  
    /**
 833:    * This method updates the specified column to have a short value.  This
 834:    * does not update the actual database.  <code>updateRow</code> must be
 835:    * called in order to do that.
 836:    *
 837:    * @param columnIndex The index of the column to update.
 838:    * @param value The new value of the column.
 839:    * @exception SQLException If an error occurs.
 840:    */
    void updateShort(int columnIndex, short value) throws SQLException;
  
    /**
 844:    * This method updates the specified column to have an int value.  This
 845:    * does not update the actual database.  <code>updateRow</code> must be
 846:    * called in order to do that.
 847:    *
 848:    * @param columnIndex The index of the column to update.
 849:    * @param value The new value of the column.
 850:    * @exception SQLException If an error occurs.
 851:    */
    void updateInt(int columnIndex, int value) throws SQLException;
  
    /**
 855:    * This method updates the specified column to have a long value.  This
 856:    * does not update the actual database.  <code>updateRow</code> must be
 857:    * called in order to do that.
 858:    *
 859:    * @param columnIndex The index of the column to update.
 860:    * @param value The new value of the column.
 861:    * @exception SQLException If an error occurs.
 862:    */
    void updateLong(int columnIndex, long value) throws SQLException;
  
    /**
 66:    * This method updates the specified column to have a float value.  This
 867:    * does not update the actual database.  <code>updateRow</code> must be
 868:    * called in order to do that.
 869:    *
 870:    * @param columnIndex The index of the column to update.
 871:    * @param value The new value of the column.
 872:    * @exception SQLException If an error occurs.
 873:    */
    void updateFloat(int columnIndex, float value) throws SQLException;
  
    /**
 877:    * This method updates the specified column to have a double value.  This
 878:    * does not update the actual database.  <code>updateRow</code> must be
 879:    * called in order to do that.
 880:    *
 881:    * @param columnIndex The index of the column to update.
 882:    * @param value The new value of the column.
 883:    * @exception SQLException If an error occurs.
 884:    */
   void updateDouble(int columnIndex, double value) throws SQLException;
  
    /**
 888:    * This method updates the specified column to have a BigDecimal value.  This
 889:    * does not update the actual database.  <code>updateRow</code> must be
 890:    * called in order to do that.
 891:    *
 892:    * @param columnIndex The index of the column to update.
 893:    * @param value The new value of the column.
 894:    * @exception SQLException If an error occurs.
 895:    */
    void updateBigDecimal(int columnIndex, BigDecimal value)
      throws SQLException;
  
    /**
 900:    * This method updates the specified column to have a String value.  This
 901:    * does not update the actual database.  <code>updateRow</code> must be
 902:    * called in order to do that.
 903:    *
 904:    * @param columnIndex The index of the column to update.
 905:    * @param value The new value of the column.
 906:    * @exception SQLException If an error occurs.
 907:    */
    void updateString(int columnIndex, String value) throws SQLException;
  
    /**
 911:    * This method updates the specified column to have a byte array value.  This
 912:    * does not update the actual database.  <code>updateRow</code> must be
 913:    * called in order to do that.
 914:    *
 915:    * @param columnIndex The index of the column to update.
 916:    * @param value The new value of the column.
 917:    * @exception SQLException If an error occurs.
 918:    */
    void updateBytes(int columnIndex, byte[] value) throws SQLException;
  
    /**
 922:    * This method updates the specified column to have a java.sql.Date value.  This
 923:    * does not update the actual database.  <code>updateRow</code> must be
 924:    * called in order to do that.
 925:    *
 926:    * @param columnIndex The index of the column to update.
 927:    * @param value The new value of the column.
 928:    * @exception SQLException If an error occurs.
 929:    */
    void updateDate(int columnIndex, Date value) throws SQLException;
  
    /**
 933:    * This method updates the specified column to have a java.sql.Time value.  This
 934:    * does not update the actual database.  <code>updateRow</code> must be
 935:    * called in order to do that.
 936:    *
 937:    * @param columnIndex The index of the column to update.
 938:    * @param value The new value of the column.
 939:    * @exception SQLException If an error occurs.
 940:    */
    void updateTime(int columnIndex, Time value) throws SQLException;
  
    /**
 944:    * This method updates the specified column to have a java.sql.Timestamp value.  
 945:    * This does not update the actual database.  <code>updateRow</code> must be
 946:    * called in order to do that.
 947:    *
 948:    * @param columnIndex The index of the column to update.
 949:    * @param value The new value of the column.
 950:    * @exception SQLException If an error occurs.
 951:    */
    void updateTimestamp(int columnIndex, Timestamp value)
      throws SQLException;
  
    /**
 956:    * This method updates the specified column from an ASCII text stream.
 957:    * This does not update the actual database.  <code>updateRow</code> must be
 958:    * called in order to do that.
 959:    *
 960:    * @param columnIndex The index of the column to update.
 961:    * @param stream The stream from which the column value is updated.
 962:    * @param count The length of the stream.
 963:    * @exception SQLException If an error occurs.
 964:    */
    void updateAsciiStream(int columnIndex, InputStream stream, int count)
      throws SQLException;
  
    /**
 969:    * This method updates the specified column from a binary stream.
 970:    * This does not update the actual database.  <code>updateRow</code> must be
 971:    * called in order to do that.
 972:    *
 973:    * @param columnIndex The index of the column to update.
 974:    * @param stream The stream from which the column value is updated.
 975:    * @param count The length of the stream.
 976:    * @exception SQLException If an error occurs.
 977:    */
    void updateBinaryStream(int columnIndex, InputStream stream, int count)
      throws SQLException;
  
    /**
 982:    * This method updates the specified column from a character stream.
 983:    * This does not update the actual database.  <code>updateRow</code> must be
 984:    * called in order to do that.
 985:    *
 986:    * @param columnIndex The index of the column to update.
 987:    * @param reader The reader from which the column value is updated.
 988:    * @param count The length of the stream.
 989:    * @exception SQLException If an error occurs.
 990:    */
    void updateCharacterStream(int columnIndex, Reader reader, int count)
      throws SQLException;
  
    /**
 995:    * This method updates the specified column to have an Object value.  
 996:    * This does not update the actual database.  <code>updateRow</code> must be
 997:    * called in order to do that.
 998:    *
 999:    * @param columnIndex The index of the column to update.
1000:    * @param value The new value of the column.
1001:    * @param scale The scale of the object in question, which is used only
1002:    *              for numeric type objects.
1003:    * @exception SQLException If an error occurs.
1004:    */
   void updateObject(int columnIndex, Object value, int scale)
     throws SQLException;
 
   /**
1009:    * This method updates the specified column to have an Object value.  
1010:    * This does not update the actual database.  <code>updateRow</code> must be
1011:    * called in order to do that.
1012:    *
1013:    * @param columnIndex The index of the column to update.
1014:    * @param value The new value of the column.
1015:    * @exception SQLException If an error occurs.
1016:    */
   void updateObject(int columnIndex, Object value) throws SQLException;
 
   /**
1020:    * This method updates the specified column to have a NULL value.  This
1021:    * does not update the actual database.  <code>updateRow</code> must be
1022:    * called in order to do that.
1023:    *
1024:    * @param columnName The name of the column to update.
1025:    * @exception SQLException If an error occurs.
1026:    */
   void updateNull(String columnName) throws SQLException;
 
 /**
1030:    * This method updates the specified column to have a boolean value.  This
1031:    * does not update the actual database.  <code>updateRow</code> must be
1032:    * called in order to do that.
1033:    *
1034:    * @param columnName The name of the column to update.
1035:    * @param value The new value of the column.
1036:    * @exception SQLException If an error occurs.
1037:    */
   void updateBoolean(String columnName, boolean value) throws SQLException;
 
   /**
1041:    * This method updates the specified column to have a byte value.  This
1042:    * does not update the actual database.  <code>updateRow</code> must be
1043:    * called in order to do that.
1044:    *
1045:    * @param columnName The name of the column to update.
1046:    * @param value The new value of the column.
1047:    * @exception SQLException If an error occurs.
1048:    */
   void updateByte(String columnName, byte value) throws SQLException;
 
   /**
1052:    * This method updates the specified column to have a short value.  This
1053:    * does not update the actual database.  <code>updateRow</code> must be
1054:    * called in order to do that.
1055:    *
1056:    * @param columnName The name of the column to update.
1057:    * @param value The new value of the column.
1058:    * @exception SQLException If an error occurs.
1059:    */
   void updateShort(String columnName, short value) throws SQLException;
 
   /**
1063:    * This method updates the specified column to have an int value.  This
1064:    * does not update the actual database.  <code>updateRow</code> must be
1065:    * called in order to do that.
1066:    *
1067:    * @param columnName The name of the column to update.
1068:    * @param value The new value of the column.
1069:    * @exception SQLException If an error occurs.
1070:    */
   void updateInt(String columnName, int value) throws SQLException;
 
   /**
1074:    * This method updates the specified column to have a long value.  This
1075:    * does not update the actual database.  <code>updateRow</code> must be
1076:    * called in order to do that.
1077:    *
1078:    * @param columnName The name of the column to update.
1079:    * @param value The new value of the column.
1080:    * @exception SQLException If an error occurs.
1081:    */
   void updateLong(String columnName, long value) throws SQLException;
 
   /**
1085:    * This method updates the specified column to have a float value.  This
1086:    * does not update the actual database.  <code>updateRow</code> must be
1087:    * called in order to do that.
1088:    *
1089:    * @param columnName The name of the column to update.
1090:    * @param value The new value of the column.
1091:    * @exception SQLException If an error occurs.
1092:    */
   void updateFloat(String columnName, float value) throws SQLException;
 
   /**
1096:    * This method updates the specified column to have a double value.  This
1097:    * does not update the actual database.  <code>updateRow</code> must be
1098:    * called in order to do that.
1099:    *
1100:    * @param columnName The name of the column to update.
1101:    * @param value The new value of the column.
1102:    * @exception SQLException If an error occurs.
1103:    */
   void updateDouble(String columnName, double value) throws SQLException;
 
   /**
1107:    * This method updates the specified column to have a BigDecimal value.  This
1108:    * does not update the actual database.  <code>updateRow</code> must be
1109:    * called in order to do that.
1110:    *
111:    * @param columnName The name of the column to update.
1112:    * @param value The new value of the column.
1113:    * @exception SQLException If an error occurs.
1114:    */
   void updateBigDecimal(String columnName, BigDecimal value)
     throws SQLException;
 
   /**
1119:    * This method updates the specified column to have a String value.  This
1120:    * does not update the actual database.  <code>updateRow</code> must be
1121:    * called in order to do that.
1122:    *
1123:    * @param columnName The name of the column to update.
1124:    * @param value The new value of the column.
1125:    * @exception SQLException If an error occurs.
1126:    */
   void updateString(String columnName, String value) throws SQLException;
 
   /**
1130:    * This method updates the specified column to have a byte array value.  This
1131:    * does not update the actual database.  <code>updateRow</code> must be
1132:    * called in order to do that.
1133:    *
1134:    * @param columnName The name of the column to update.
1135:    * @param value The new value of the column.
1136:    * @exception SQLException If an error occurs.
1137:    */
   void updateBytes(String columnName, byte[] value) throws SQLException;
 
   /**
1141:    * This method updates the specified column to have a java.sql.Date value.  This
1142:    * does not update the actual database.  <code>updateRow</code> must be
1143:    * called in order to do that.
1144:    *
1145:    * @param columnName The name of the column to update.
1146:    * @param value The new value of the column.
1147:    * @exception SQLException If an error occurs.
1148:    */
   void updateDate(String columnName, Date value) throws SQLException;
 
   /**
1152:    * This method updates the specified column to have a java.sql.Time value.  This
1153:    * does not update the actual database.  <code>updateRow</code> must be
1154:    * called in order to do that.
1155:    *
1156:    * @param columnName The name of the column to update.
1157:    * @param value The new value of the column.
1158:    * @exception SQLException If an error occurs.
1159:    */
   void updateTime(String columnName, Time value) throws SQLException;
 
   /**
1163:    * This method updates the specified column to have a java.sql.Timestamp value.  
1164:    * This does not update the actual database.  <code>updateRow</code> must be
1165:    * called in order to do that.
1166:    *
1167:    * @param columnName The name of the column to update.
1168:    * @param value The new value of the column.
1169:    * @exception SQLException If an error occurs.
1170:    */
  void updateTimestamp(String columnName, Timestamp value)
     throws SQLException;
 
   /**
1175:    * This method updates the specified column from an ASCII text stream.
1176:    * This does not update the actual database.  <code>updateRow</code> must be
1177:    * called in order to do that.
1178:    *
1179:    * @param columnName The name of the column to update.
1180:    * @param stream The stream from which the column value is updated.
1181:    * @param count The length of the stream.
1182:    * @exception SQLException If an error occurs.
1183:    */
   void updateAsciiStream(String columnName, InputStream stream, int count)
     throws SQLException;
 
   /**
1188:    * This method updates the specified column from a binary stream.
1189:    * This does not update the actual database.  <code>updateRow</code> must be
1190:    * called in order to do that.
1191:    *
1192:    * @param columnName The name of the column to update.
1193:    * @param stream The stream from which the column value is updated.
1194:    * @param count The length of the stream.
1195:    * @exception SQLException If an error occurs.
1196:    */
   void updateBinaryStream(String columnName, InputStream stream, int count)
    throws SQLException;
 
   /**
1201:    * This method updates the specified column from a character stream.
1202:    * This does not update the actual database.  <code>updateRow</code> must be
1203:    * called in order to do that.
1204:    *
1205:    * @param columnName The name of the column to update.
1206:    * @param reader The reader from which the column value is updated.
1207:    * @param count The length of the stream.
1208:    * @exception SQLException If an error occurs.
1209:    */
   void updateCharacterStream(String columnName, Reader reader, int count)
     throws SQLException;
 
   /**
214:    * This method updates the specified column to have an Object value.  
1215:    * This does not update the actual database.  <code>updateRow</code> must be
1216:    * called in order to do that.
1217:    *
1218:    * @param columnName The name of the column to update.
1219:    * @param value The new value of the column.
1220:    * @param scale The scale of the object in question, which is used only
1221:    *              for numeric type objects.
1222:    * @exception SQLException If an error occurs.
1223:    */
   void updateObject(String columnName, Object value, int scale)
     throws SQLException;
 
   /**
1228:    * This method updates the specified column to have an Object value.  
1229:    * This does not update the actual database.  <code>updateRow</code> must be
1230:    * called in order to do that.
1231:    *
1232:    * @param columnName The name of the column to update.
1233:    * @param value The new value of the column.
1234:    * @exception SQLException If an error occurs.
1235:    */
   void updateObject(String columnName, Object value) throws SQLException;
 
 /**
239:    * This method inserts the current row into the database.  The result set
1240:    * must be positioned on the insert row in order to call this method
1241:    * successfully.
1242:    *
1243:    * @exception SQLException If an error occurs.
1244:    */
   void insertRow() throws SQLException;
 
   /**
1248:    * This method updates the current row in the database.
1249:    *
1250:    * @exception SQLException If an error occurs.
1251:    */
   void updateRow() throws SQLException;
 
   /**
1255:    * This method deletes the current row in the database.
1256:    *
1257:    * @exception SQLException If an error occurs.
1258:    */
   void deleteRow() throws SQLException;

   /**
1262:    * This method refreshes the contents of the current row from the database.
1263:    *
1264:    * @exception SQLException If an error occurs.
1265:    */
   void refreshRow() throws SQLException;
 
   /**
1269:    * This method cancels any changes that have been made to a row.  If 
1270:    * the <code>rowUpdate</code> method has been called, then the changes
1271:    * cannot be undone.
1272:    *
1273:    * @exception SQLException If an error occurs.
1274:    */
   void cancelRowUpdates() throws SQLException;
 
   /**
1278:    * This method positions the result set to the "insert row", which allows
1279:    * a new row to be inserted into the database from the result set.
1280:    *
1281:    * @exception SQLException If an error occurs.
1282:    */
   void moveToInsertRow() throws SQLException;
 
   /**
1286:    * This method moves the result set position from the insert row back to
1287:    * the current row that was selected prior to moving to the insert row.
1288:    *
1289:    * @exception SQLException If an error occurs.
1290:    */
   void moveToCurrentRow() throws SQLException;
 
   /**
1294:    * This method returns a the <code>Statement</code> that was used to
1295:    * produce this result set.
1296:    *
1297:    * @return The <code>Statement</code> used to produce this result set.
1298:    *
1299:    * @exception SQLException If an error occurs.
1300:    */
   Statement getStatement() throws SQLException;
 
   /**
1304:    * This method returns the value of the specified column as a Java
1305:    * <code>Object</code> using the specified SQL type to Java type map.
1306:    *
1307:    * @param columnIndex The index of the column to return.
1308:    * @param map The SQL type to Java type map to use.
1309:    * @return The value of the column as an <code>Object</code>.
1310:    * @exception SQLException If an error occurs.
1311:    */
   Object getObject(int columnIndex, Map<String, Class<?>> map)
     throws SQLException;
 
   /**
1316:    * This method returns a <code>Ref</code> for the specified column which
1317:    * represents the structured type for the column.
1318:    *
1319:    * @param columnIndex The index of the column to return.
1320:    * @return A <code>Ref</code> object for the column
1321:    * @exception SQLException If an error occurs.
1322:    */
   Ref getRef(int columnIndex) throws SQLException;
 
   /**
26:    * This method returns the specified column value as a BLOB.
1327:    *
1328:    * @param columnIndex The index of the column value to return.
1329:    * @return The value of the column as a BLOB.
1330:    * @exception SQLException If an error occurs.
1331:    */
   Blob getBlob(int columnIndex) throws SQLException;
 
   /**
1335:    * This method returns the specified column value as a CLOB.
1336:    *
1337:    * @param columnIndex The index of the column value to return.
1338:    * @return The value of the column as a CLOB.
1339:    * @exception SQLException If an error occurs.
1340:    */
   Clob getClob(int columnIndex) throws SQLException;
 
   /**
1344:    * This method returns the specified column value as an <code>Array</code>.
1345:    *
1346:    * @param columnIndex The index of the column value to return.
1347:    * @return The value of the column as an <code>Array</code>.
1348:    * @exception SQLException If an error occurs.
1349:    */
   Array getArray(int columnIndex) throws SQLException;
 
   /**
1353:    * This method returns the value of the specified column as a Java
1354:    * <code>Object</code> using the specified SQL type to Java type map.
1355:    *
1356:    * @param columnName The name of the column to return.
1357:    * @param map The SQL type to Java type map to use.
1358:    * @return The value of the column as an <code>Object</code>.
1359:    * @exception SQLException If an error occurs.
1360:    */
   Object getObject(String columnName, Map<String, Class<?>> map) 
     throws SQLException;
 
   /**
65:    * This method returns a <code>Ref</code> for the specified column which
1366:    * represents the structured type for the column.
1367:    *
1368:    * @param columnName  The name of the column to return.
1369:    * @return A <code>Ref</code> object for the column
1370:    * @exception SQLException If an error occurs.
1371:    */
   Ref getRef(String columnName) throws SQLException;
 
   /**
1375:    * This method returns the specified column value as a BLOB.
1376:    *
1377:    * @param columnName The name of the column value to return.
1378:    * @return The value of the column as a BLOB.
1379:    * @exception SQLException If an error occurs.
1380:    */
   Blob getBlob(String columnName) throws SQLException;
 
   /**
1384:    * This method returns the specified column value as a CLOB.
1385:    *
1386:    * @param columnName The name of the column value to return.
1387:    * @return The value of the column as a CLOB.
1388:    * @exception SQLException If an error occurs.
1389:    */
   Clob getClob(String columnName) throws SQLException;
 
   /**
1393:    * This method returns the specified column value as an <code>Array</code>.
1394:    *
1395:    * @param columnName The name of the column value to return.
1396:    * @return The value of the column as an <code>Array</code>.
1397:    * @exception SQLException If an error occurs.
1398:    */
   Array getArray(String columnName) throws SQLException;
 
   /**
1402:    * This method returns the specified column value as a 
1403:    * <code>java.sql.Date</code>.  The specified <code>Calendar</code> is used
1404:    * to generate a value for the date if the database does not support
1405:    * timezones.
1406:    *
407:    * @param columnIndex The index of the column value to return.
1408:    * @param cal The <code>Calendar</code> to use for calculating timezones.
1409:    * @return The value of the column as a <code>java.sql.Date</code>.
1410:    * @exception SQLException If an error occurs.
1411:    */
   Date getDate(int columnIndex, Calendar cal) throws SQLException;
 
   /**
1415:    * This method returns the specified column value as a 
1416:    * <code>java.sql.Date</code>.  The specified <code>Calendar</code> is used
1417:    * to generate a value for the date if the database does not support
1418:    * timezones.
1419:    *
1420:    * @param columnName The name of the column value to return.
1421:    * @param cal The <code>Calendar</code> to use for calculating timezones.
1422:    * @return The value of the column as a <code>java.sql.Date</code>.
1423:    * @exception SQLException If an error occurs.
1424:    */
   Date getDate(String columnName, Calendar cal) throws SQLException;
 
   /**
1428:    * This method returns the specified column value as a 
1429:    * <code>java.sql.Time</code>.  The specified <code>Calendar</code> is used
1430:    * to generate a value for the time if the database does not support
1431:    * timezones.
1432:    *
1433:    * @param columnIndex The index of the column value to return.
1434:    * @param cal The <code>Calendar</code> to use for calculating timezones.
1435:    * @return The value of the column as a <code>java.sql.Time</code>.
1436:    * @exception SQLException If an error occurs.
1437:    */
   Time getTime(int columnIndex, Calendar cal) throws SQLException;
 
   /**
441:    * This method returns the specified column value as a 
1442:    * <code>java.sql.Time</code>.  The specified <code>Calendar</code> is used
1443:    * to generate a value for the time if the database does not support
1444:    * timezones.
1445:    *
1446:    * @param columnName The name of the column value to return.
1447:    * @param cal The <code>Calendar</code> to use for calculating timezones.
1448:    * @return The value of the column as a <code>java.sql.Time</code>.
1449:    * @exception SQLException If an error occurs.
1450:    */
   Time getTime(String columnName, Calendar cal) throws SQLException;
 
   /**
1454:    * This method returns the specified column value as a 
1455:    * <code>java.sql.Timestamp</code>.  The specified <code>Calendar</code> is used
1456:    * to generate a value for the timestamp if the database does not support
1457:    * timezones.
1458:    *
1459:    * @param columnIndex The index of the column value to return.
1460:    * @param cal The <code>Calendar</code> to use for calculating timezones.
1461:    * @return The value of the column as a <code>java.sql.Timestamp</code>.
1462:    * @exception SQLException If an error occurs.
1463:    */
   Timestamp getTimestamp(int columnIndex, Calendar cal)
     throws SQLException;
 
   /**
1468:    * This method returns the specified column value as a 
1469:    * <code>java.sql.Timestamp</code>.  The specified <code>Calendar</code> is used
1470:    * to generate a value for the timestamp if the database does not support
1471:    * timezones.
1472:    *
1473:    * @param columnName The name of the column value to return.
1474:    * @param cal The <code>Calendar</code> to use for calculating timezones.
1475:    *
1476:    * @return The value of the column as a <code>java.sql.Timestamp</code>.
1477:    *
1478:    * @exception SQLException If an error occurs.
1479:    */
   Timestamp getTimestamp(String columnName, Calendar cal)
     throws SQLException;
 
   /**
1484:    * This method returns the specified column value as a 
1485:    * <code>java.net.URL</code>.
1486:    * 
1487:    * @param columnIndex The index of the column value to return.
1488:    * @exception SQLException If an error occurs.
1489:    * @since 1.4
1490:    */
   URL getURL(int columnIndex) throws SQLException;
 
   /**
1494:    * This method returns the specified column value as a
1495:    * <code>java.net.URL</code>.
1496:    * 
1497:    * @param columnName The name of the column value to return.
1498:    * @exception SQLException If an error occurs.
1499:    * @since 1.4
1500:    */
   URL getURL(String columnName) throws SQLException;
 
   /**
1504:    * This method updates the specified column to have a 
1505:    * <code>java.sql.Ref</code> value. 
1506:    * This does not update the actual database. <code>updateRow</code> must be
1507:    * called in order to do that.
1508:    * 
1509:    * @parm columnIndex The index of the column value to update.
1510:    * @parm value The <code>java.sql.Ref</code> used to set the new value 
1511:    *             of the column.
1512:    * @exception SQLException If an error occurs.
1513:    * @since 1.4
1514:    */
   void updateRef(int columnIndex, Ref value) throws SQLException;
 
   /**
1518:    * This method updates the specified column to have a 
1519:    * <code>java.sql.Ref</code> value. 
1520:    * This does not update the actual database. <code>updateRow</code> must be
1521:    * called in order to do that.
1522:    * 
1523:    * @parm columnName The name of the column value to update.
1524:    * @parm value The <code>java.sql.Ref</code> used to set the new value 
1525:    *             of the column.
1526:    * @exception SQLException If an error occurs.
1527:    * @since 1.4
1528:    */
   void updateRef(String columnName, Ref value) throws SQLException;
 
   /**
1532:    * This method updates the specified column to have a 
1533:    * <code>java.sql.Blob</code> value. 
1534:    * This does not update the actual database. <code>updateRow</code> must be
1535:    * called in order to do that.
1536:    * 
1537:    * @parm columnIndex The index of the column value to update.
1538:    * @parm value The <code>java.sql.Blob</code> used to set the new value 
1539:    *             of the column.
1540:    * @exception SQLException If an error occurs.
1541:    * @since 1.4
1542:    */
   void updateBlob(int columnIndex, Blob value) throws SQLException;
 
   /**
1546:    * This method updates the specified column to have a 
1547:    * <code>java.sql.Blob</code> value. 
1548:    * This does not update the actual database. <code>updateRow</code> must be
1549:    * called in order to do that.
1550:    * 
1551:    * @parm columnName The name of the column value to update.
1552:    * @parm value The <code>java.sql.Blob</code> used to set the new value 
1553:    *             of the column.
1554:    * @exception SQLException If an error occurs.
1555:    * @since 1.4
1556:    */
   void updateBlob(String columnName, Blob value) throws SQLException;
 
   /**
1560:    * This method updates the specified column to have a 
1561:    * <code>java.sql.Clob</code> value. 
1562:    * This does not update the actual database. <code>updateRow</code> must be
1563:    * called in order to do that.
1564:    * 
1565:    * @parm columnIndex The index of the column value to update.
1566:    * @parm value The <code>java.sql.Clob</code> used to set the new value 
1567:    *             of the column.
1568:    * @exception SQLException If an error occurs.
1569:    * @since 1.4
1570:    */
   void updateClob(int columnIndex, Clob value) throws SQLException;
 
   /**
1574:    * This method updates the specified column to have a 
1575:    * <code>java.sql.Clob</code> value. 
1576:    * This does not update the actual database. <code>updateRow</code> must be
1577:    * called in order to do that.
1578:    * 
1579:    * @parm columnName The name of the column value to update.
1580:    * @parm value The <code>java.sql.Clob</code> used to set the new value 
581:    *             of the column.
1582:    * @exception SQLException If an error occurs.
1583:    * @since 1.4
1584:    */
   void updateClob(String columnName, Clob value) throws SQLException;
 
   /**
1588:    * This method updates the specified column to have a 
1589:    * <code>java.sqlArray</code> value. 
1590:    * This does not update the actual database. <code>updateRow</code> must be
1591:    * called in order to do that.
1592:    * 
1593:    * @parm columnIndex The index of the column value to update.
1594:    * @parm value The new value of the column.
1595:    * @exception SQLException If an error occurs.
1596:    * @since 1.4
1597:    */
   void updateArray(int columnIndex, Array value) throws SQLException;
 
   /**
1601:    * This method updates the specified column to have a 
1602:    * <code>java.sqlArray</code> value. 
1603:    * This does not update the actual database. <code>updateRow</code> must be
1604:    * called in order to do that.
1605:    * 
1606:    * @parm columnName The name of the column value to update.
1607:    * @parm value The new value of the column.
1608:    * @exception SQLException If an error occurs.
1609:    * @since 1.4
1610:    */
   void updateArray(String columnName, Array value) throws SQLException;
 }
