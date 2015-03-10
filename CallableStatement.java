package java.sql.start;
   
   import java.io.InputStream;
   import java.io.Reader;
   import java.math.BigDecimal;
  import java.net.URL;
   import java.util.Calendar;
   import java.util.Map;
   
   /**
  48:  * This interface provides a mechanism for calling stored procedures.
  49:  *
  50:  * @author Aaron M. Renn (arenn@urbanophile.com)
  1:  */
   public interface CallableStatement extends PreparedStatement 
   {
     /**
  55:    * This method registers the specified parameter as an output parameter
  56:    * of the specified SQL type.
  57:    *
  58:    * @param index The index of the parameter to register as output.
  59:    * @param sqlType The SQL type value from <code>Types</code>.
  60:    * @exception SQLException If an error occurs.
  61:    */   
     void registerOutParameter(int index, int sqlType)
       throws SQLException;
   
     /**
  66:    * This method registers the specified parameter as an output parameter
  67:    * of the specified SQL type and scale.
  68:    *
  69:    * @param index The index of the parameter to register as output.
  70:    * @param sqlType The SQL type value from <code>Types</code>.
  71:    * @param scale The scale of the value that will be returned.
  72:    * @exception SQLException If an error occurs.
  73:    */   
     void registerOutParameter(int index, int sqlType, int scale)
       throws SQLException;
   
     /**
  78:    * This method tests whether the value of the last parameter that was fetched
  79:    * was actually a SQL NULL value.
  80:    *
  81:    * @return <code>true</code> if the last parameter fetched was a NULL,
  82:    *         <code>false</code> otherwise.
  83:    * @exception SQLException If an error occurs.
  84:    */
     boolean wasNull() throws SQLException;
   
     /**
  88:    * This method returns the value of the specified parameter as a Java
  89:    * <code>String</code>.
  90:    *
  91:    * @param index The index of the parameter to return.
  92:    * @return The parameter value as a <code>String</code>.
  93:    * @exception SQLException If an error occurs.
  94:    */
     String getString(int index) throws SQLException;
   
     /**
  98:    * This method returns the value of the specified parameter as a Java
  99:    * <code>boolean</code>.
 100:    *
 101:    * @param index The index of the parameter to return.
 102:    * @return The parameter value as a <code>boolean</code>.
 103:    * @exception SQLException If an error occurs.
 104:    */
    boolean getBoolean(int index) throws SQLException;
  
    /**
 108:    * This method returns the value of the specified parameter as a Java
 109:    * <code>byte</code>.
 110:    *
 111:    * @param index The index of the parameter to return.
 112:    * @return The parameter value as a <code>byte</code>.
 113:    * @exception SQLException If an error occurs.
 114:    */
    byte getByte(int index) throws SQLException;
  
    /**
 118:    * This method returns the value of the specified parameter as a Java
 119:    * <code>short</code>.
 120:    *
 121:    * @param index The index of the parameter to return.
 122:    * @return The parameter value as a <code>short</code>.
 123:    * @exception SQLException If an error occurs.
 124:    */
    short getShort(int index) throws SQLException;
  
    /**
 128:    * This method returns the value of the specified parameter as a Java
 129:    * <code>int</code>.
 130:    *
 131:    * @param index The index of the parameter to return.
 132:    * @return The parameter value as a <code>int</code>.
 133:    * @exception SQLException If an error occurs.
 134:    */
    int getInt(int index) throws SQLException;
  
    /**
 138:    * This method returns the value of the specified parameter as a Java
 139:    * <code>long</code>.
 140:    *
 141:    * @param index The index of the parameter to return.
 142:    * @return The parameter value as a <code>long</code>.
 143:    * @exception SQLException If an error occurs.
 144:    */
    long getLong(int index) throws SQLException;
  
    /**
 148:    * This method returns the value of the specified parameter as a Java
 149:    * <code>float</code>.
 150:    *
 151:    * @param index The index of the parameter to return.
 152:    * @return The parameter value as a <code>float</code>.
 153:    * @exception SQLException If an error occurs.
 154:    */
    float getFloat(int index) throws SQLException;
  
    /**
 8:    * This method returns the value of the specified parameter as a Java
 159:    * <code>double</code>.
 160:    *
 161:    * @param index The index of the parameter to return.
 162:    * @return The parameter value as a <code>double</code>.
 163:    * @exception SQLException If an error occurs.
 164:    */
    double getDouble(int index) throws SQLException;
  
    /**
 168:    * This method returns the value of the specified parameter as a Java
 169:    * <code>BigDecimal</code>.
 170:    *
 171:    * @param index The index of the parameter to return.
 172:    * @param scale The number of digits to the right of the decimal to return.
 173:    * @return The parameter value as a <code>BigDecimal</code>.
 174:    * @exception SQLException If an error occurs.
 175:    * @deprecated Use getBigDecimal(int index)
 176:    *             or getBigDecimal(String name) instead.
 177:    */
    BigDecimal getBigDecimal(int index, int scale)
      throws SQLException;
  
    /**
 182:    * This method returns the value of the specified parameter as a Java
 183:    * byte array.
 184:    *
 185:    * @param index The index of the parameter to return.
 186:    * @return The parameter value as a byte array
 187:    * @exception SQLException If an error occurs.
 188:    */
    byte[] getBytes(int index) throws SQLException;
  
    /**
 192:    * This method returns the value of the specified parameter as a Java
 193:    * <code>java.sql.Date</code>.
 194:    *
 195:    * @param index The index of the parameter to return.
 196:    * @return The parameter value as a <code>java.sql.Date</code>.
 197:    * @exception SQLException If an error occurs.
 198:    */
    Date getDate(int index) throws SQLException;
  
    /**
 202:    * This method returns the value of the specified parameter as a Java
 203:    * <code>java.sql.Time</code>.
 204:    *
 205:    * @param index The index of the parameter to return.
 206:    * @return The parameter value as a <code>java.sql.Time</code>.
 207:    * @exception SQLException If an error occurs.
 208:    */
    Time getTime(int index) throws SQLException;
  
    /**
 212:    * This method returns the value of the specified parameter as a Java
 213:    * <code>java.sql.Timestamp</code>.
 214:    *
 215:    * @param index The index of the parameter to return.
 216:    * @return The parameter value as a <code>java.sql.Timestamp</code>.
 217:    * @exception SQLException If an error occurs.
 218:    */
    Timestamp getTimestamp(int index) throws SQLException;
  
    /**
 222:    * This method returns the value of the specified parameter as a Java
 223:    * <code>Object</code>.
 224:    *
 225:    * @param index The index of the parameter to return.
 226:    * @return The parameter value as an <code>Object</code>.
 227:    * @exception SQLException If an error occurs.
 228:    * @since 1.2
 229:    */
    Object getObject(int index) throws SQLException;
  
    /**
 233:    * This method returns the value of the specified parameter as a Java
 234:    * <code>BigDecimal</code>.
 235:    *
 236:    * @param index The index of the parameter to return.
 237:    * @return The parameter value as a <code>BigDecimal</code>.
 238:    * @exception SQLException If an error occurs.
 239:    * @since 1.2
 240:    */
    BigDecimal getBigDecimal(int index) throws SQLException;
  
    /**
 244:    * This method returns the value of the specified parameter as a Java
 245:    * <code>Object</code>.
 246:    *
 247:    * @param index The index of the parameter to return.
 248:    * @param map The mapping to use for conversion from SQL to Java types.
 249:    * @return The parameter value as an <code>Object</code>.
 250:    * @exception SQLException If an error occurs.
 251:    * @since 1.2
 252:    */
    Object getObject(int index, Map<String, Class<?>> map) throws SQLException;
  
    /**
 256:    * This method returns the value of the specified parameter as a Java
 257:    * <code>Ref</code>.
 258:    *
 259:    * @param index The index of the parameter to return.
 260:    * @return The parameter value as a <code>Ref</code>.
 261:    * @exception SQLException If an error occurs.
 262:    * @since 1.2
 263:    */
    Ref getRef(int index) throws SQLException;
  
    /**
 267:    * This method returns the value of the specified parameter as a Java
 268:    * <code>Blob</code>.
 269:    *
 270:    * @param index The index of the parameter to return.
 271:    * @return The parameter value as a <code>Blob</code>.
 272:    * @exception SQLException If an error occurs.
 273:    * @since 1.2
 274:    */   
    Blob getBlob(int index) throws SQLException;
  
    /**
 278:    * This method returns the value of the specified parameter as a Java
 279:    * <code>Clob</code>.
 280:    *
 281:    * @param index The index of the parameter to return.
 282:    * @return The parameter value as a <code>Clob</code>.
 283:    * @exception SQLException If an error occurs.
 284:    * @since 1.2
 285:    */
    Clob getClob(int index) throws SQLException;
  
    /**
 89:    * This method returns the value of the specified parameter as a Java
 290:    * <code>Array</code>.
 291:    *
 292:    * @param index The index of the parameter to return.
 293:    * @return The parameter value as a <code>Array</code>.
 294:    * @exception SQLException If an error occurs.
 295:    * @since 1.2
 296:    */
    Array getArray(int index) throws SQLException;
  
    /**
 300:    * This method returns the value of the specified parameter as a Java
 301:    * <code>java.sql.Date</code>.
 302:    *
 303:    * @param index The index of the parameter to return.
 304:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 305:    * @return The parameter value as a <code>java.sql.Date</code>.
 306:    * @exception SQLException If an error occurs.
 307:    * @since 1.2
 308:    */
    Date getDate(int index, Calendar cal) throws SQLException;
  
    /**
 312:    * This method returns the value of the specified parameter as a Java
 313:    * <code>java.sql.Time</code>.
 314:    *
 315:    * @param index The index of the parameter to return.
 316:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 317:    * @return The parameter value as a <code>java.sql.Time</code>.
 318:    * @exception SQLException If an error occurs.
 319:    * @since 1.2
 320:    */
    Time getTime(int index, Calendar cal) throws SQLException;
 
    /**
 324:    * This method returns the value of the specified parameter as a Java
 325:    * <code>java.sql.Timestamp</code>.
 326:    *
 327:    * @param index The index of the parameter to return.
 328:    * @return The parameter value as a <code>java.sql.Timestamp</code>.
 329:    * @exception SQLException If an error occurs.
 330:    * @since 1.2
 331:    */
    Timestamp getTimestamp(int index, Calendar cal)
      throws SQLException;
   /**
 336:    * This method registers the specified parameter as an output parameter
 337:    * of the specified SQL type.
 338:    *
 339:    * @param index The index of the parameter to register as output.
 340:    * @param sqlType The SQL type value from <code>Types</code>.
 341:    * @param typeName The user defined data type name.
 342:    * @exception SQLException If an error occurs.
 343:    * @since 1.2
 344:    */
    void registerOutParameter(int index, int sqlType, String typeName)
      throws SQLException;
  
    /**
 349:    * This method registers the specified parameter as an output parameter
 350:    * of the specified SQL type.
 351:    *
 352:    * @param name The name of the parameter to register as output.
 353:    * @param sqlType The SQL type value from <code>Types</code>.
 354:    * @exception SQLException If an error occurs.
 355:    * @since 1.4
 356:    */
    void registerOutParameter(String name, int sqlType)
      throws SQLException;
  
    /**
 361:    * This method registers the specified parameter as an output parameter
 362:    * of the specified SQL type.  This version of registerOutParameter is used 
 363:    * for NUMERIC or DECIMAL types.
 364:    *
 365:    * @param name The name of the parameter to register as output.
 366:    * @param sqlType The SQL type value from <code>Types</code>.
 367:    * @param scale Number of digits to the right of the decimal point.
 368:    * @exception SQLException If an error occurs.
 369:    * @since 1.4
 370:    */
    void registerOutParameter(String name, int sqlType, int scale)
      throws SQLException;
  
  
    /**
 376:    * This method registers the specified parameter as an output parameter
 377:    * of the specified SQL type.  This version of registerOutParameter is used 
 378:    * for user-named or REF types. If the type of the output parameter does
 379:    * not have such a type, the typeName argument is ignored.
 380:    *
 381:    * @param name The name of the parameter to register as output.
 382:    * @param sqlType The SQL type value from <code>Types</code>.
 383:    * @param typeName The SQL structured type name.
 384:    * @exception SQLException If an error occurs.
 385:    * @since 1.4
 386:    */
    void registerOutParameter(String name, int sqlType, String typeName) 
      throws SQLException;
  
    /**
 391:    * This method returns the value of the specified parameter as a Java
 392:    * <code>java.net.URL</code>.
 393:    *
 394:    * @param index The index of the parameter to return.
 395:    * @return The parameter value as a <code>URL</code>.
 396:    * @exception SQLException If an error occurs.
 397:    * @since 1.4
 398:    */
    URL getURL(int index) throws SQLException;
  
    /**
 402:    * This method sets the value of the specified parameter to the specified
 403:    * <code>java.net.URL</code>
 404:    * 
 405:    * @param name The name of the parameter to set.
 406:    * @param value The value the parameter.
 407:    * @since 1.4
 408:    */
    void setURL(String name, URL value) throws SQLException;
 
    /**
 412:    * This method populates the specified parameter with a SQL NULL value
 413:    * for the specified type.
 414:    *
 415:    * @param name The name of the parameter to set.
 416:    * @param sqlType The SQL type identifier of the parameter from 
 417:    *                <code>Types</code>
 418:    * @exception SQLException If an error occurs.
 419:    * @since 1.4
 420:    */
    void setNull(String name, int sqlType) throws SQLException;
  
    /**
 424:    * This method sets the specified parameter from the given Java
 425:    * <code>boolean</code> value.
 426:    *
 427:    * @param name The name of the parameter value to set.
 428:    * @param value The value of the parameter.
 429:    * @exception SQLException If an error occurs.
 430:    * @since 1.4
 431:    */
    void setBoolean(String name, boolean value) throws SQLException;
  
    /**
 435:    * This method sets the specified parameter from the given Java
 436:    * <code>byte</code> value.
 437:    *
 438:    * @param name The name of the parameter value to set.
 439:    * @param value The value of the parameter.
 440:    * @exception SQLException If an error occurs.
 441:    * @since 1.4
 442:    */
    void setByte(String name, byte value) throws SQLException;
  
    /**
 446:    * This method sets the specified parameter from the given Java
 447:    * <code>short</code> value.
 448:    *
 449:    * @param name The name of the parameter value to set.
 450:    * @param value The value of the parameter.
 451:    * @exception SQLException If an error occurs.
 452:    * @since 1.4
 453:    */
    void setShort(String name, short value) throws SQLException;
  
    /**
 457:    * This method sets the specified parameter from the given Java
 458:    * <code>int</code> value.
 459:    *
 460:    * @param name The name of the parameter value to set.
 461:    * @param value The value of the parameter.
 462:    * @exception SQLException If an error occurs.
 463:    * @since 1.4
 464:    */
   void setInt(String name, int value) throws SQLException;

    /**
 468:    * This method sets the specified parameter from the given Java
 469:    * <code>long</code> value.
 470:    *
 471:    * @param name The name of the parameter value to set.
 472:    * @param value The value of the parameter.
 473:    * @exception SQLException If an error occurs.
 474:    * @since 1.4
 475:    */
    void setLong(String name, long value) throws SQLException;
  
    /**
 479:    * This method sets the specified parameter from the given Java
 480:    * <code>float</code> value.
 481:    *
 482:    * @param name The name of the parameter value to set.
 483:    * @param value The value of the parameter.
 484:    * @exception SQLException If an error occurs.
 485:    * @since 1.4
 486:    */
    void setFloat(String name, float value) throws SQLException;
  
    /**
 490:    * This method sets the specified parameter from the given Java
 491:    * <code>double</code> value.
 492:    *
 493:    * @param name The name of the parameter value to set.
 494:    * @param value The value of the parameter.
 495:    * @exception SQLException If an error occurs.
 496:    * @since 1.4
 497:    */
   void setDouble(String name, double value) throws SQLException;
  
    /**
 501:    * This method sets the specified parameter from the given Java
 502:    * <code>BigDecimal</code> value.
 503:    *
 504:    * @param name The name of the parameter value to set.
 505:    * @param value The value of the parameter.
 506:    * @exception SQLException If an error occurs.
 507:    * @since 1.4
 508:    */
    void setBigDecimal(String name, BigDecimal value)
      throws SQLException;
  
    /**
 513:    * This method sets the specified parameter from the given Java
 514:    * <code>String</code> value.
 515:    *
 516:    * @param name The name of the parameter value to set.
 517:    * @param value The value of the parameter.
 518:    * @exception SQLException If an error occurs.
 519:    * @since 1.4
 520:    */
    void setString(String name, String value) throws SQLException;
  
    /**
 4:    * This method sets the specified parameter from the given Java
 525:    * <code>byte</code> array value.
 526:    *
 527:    * @param name The name of the parameter value to set.
 528:    * @param value The value of the parameter.
 529:    * @exception SQLException If an error occurs.
 530:    * @since 1.4
 531:    */
    void setBytes(String name, byte[] value) throws SQLException;
  
    /**
 535:    * This method sets the specified parameter from the given Java
 536:    * <code>java.sql.Date</code> value.
 537:    *
 538:    * @param name The name of the parameter value to set.
 539:    * @param value The value of the parameter.
 540:    * @exception SQLException If an error occurs.
 541:    * @since 1.4
 542:    */
    void setDate(String name, Date value) throws SQLException;
  
    /**
 546:    * This method sets the specified parameter from the given Java
 547:    * <code>java.sql.Time</code> value.
 548:    *
 549:    * @param name The name of the parameter value to set.
 550:    * @param value The value of the parameter.
 551:    * @exception SQLException If an error occurs.
 552:    * @since 1.4
 553:    */
    void setTime(String name, Time value) throws SQLException;
  
    /**
 557:    * This method sets the specified parameter from the given Java
 558:    * <code>java.sql.Timestamp</code> value.
 559:    *
 560:    * @param name The name of the parameter value to set.
 561:    * @param value The value of the parameter.
 562:    * @exception SQLException If an error occurs.
 563:    * @since 1.4
 564:    */
    void setTimestamp(String name, Timestamp value)
      throws SQLException;
  
    /**
 569:    * This method sets the specified parameter from the given Java
 570:    * ASCII <code>InputStream</code> value.
 571:    *
 572:    * @param name The name of the parameter value to set.
 573:    * @param stream The stream from which the parameter value is read.
 574:    * @param count The number of bytes in the stream.
 575:    * @exception SQLException If an error occurs.
 576:    * @since 1.4
 577:    */
    void setAsciiStream(String name, InputStream stream, int count)
        throws SQLException;
  
    /**
 582:    * This method sets the specified parameter from the given Java
 583:    * binary <code>InputStream</code> value.
 584:    *
 585:    * @param name The name of the parameter value to set.
 586:    * @param stream The stream from which the parameter value is read.
 587:    * @param count The number of bytes in the stream.
 588:    * @exception SQLException If an error occurs.
 589:    * @since 1.4
 590:    */
    void setBinaryStream(String name, InputStream stream, int count)
       throws SQLException;
  
    /**
 595:    * This method sets the specified parameter from the given Java
 596:    * <code>Object</code> value.  The specified SQL object type will be used.
 597:    *
 598:    * @param name The name of the parameter value to set.
 599:    * @param value The value of the parameter.
 600:    * @param sqlType The SQL type to use for the parameter, from 
 601:    *                <code>Types</code>
 602:    * @param scale The scale of the value, for numeric values only.
 603:    * @exception SQLException If an error occurs.
 604:    * @see Types
 605:    * @since 1.4
 606:    */
    void setObject(String name, Object value, int sqlType, int scale)
      throws SQLException;
  
    /**
 611:    * This method sets the specified parameter from the given Java
 612:    * <code>Object</code> value.  The specified SQL object type will be used.
 613:    *
 614:    * @param name The name of the parameter value to set.
 615:    * @param value The value of the parameter.
 616:    * @param sqlType The SQL type to use for the parameter, from 
 617:    *                <code>Types</code>
 618:    * @exception SQLException If an error occurs.
 619:    * @see Types
 620:    * @since 1.4
 621:    */
    void setObject(String name, Object value, int sqlType)
      throws SQLException;
  
    /**
 26:    * This method sets the specified parameter from the given Java
 627:    * <code>Object</code> value.  The default object type to SQL type mapping
 628:    * will be used.
 629:    *
 630:    * @param name The name of the parameter value to set.
 631:    * @param value The value of the parameter.
 632:    * @exception SQLException If an error occurs.
 633:    * @since 1.4
 634:    */
    void setObject(String name, Object value) throws SQLException;
  
    /**
 8:    * This method sets the specified parameter from the given Java
 639:    * character <code>Reader</code> value.
 640:    *
 641:    * @param name The name of the parameter value to set.
 642:    * @param reader The reader from which the parameter value is read.
 643:    * @param count The number of characters in the stream.
 644:    * @exception SQLException If an error occurs.
 645:    * @since 1.4
 646:    */
    void setCharacterStream(String name, Reader reader, int count)
      throws SQLException;
  
    /**
 51:    * This method sets the specified parameter from the given Java
 652:    * <code>java.sql.Date</code> value.
 653:    *
 654:    * @param name The name of the parameter value to set.
 655:    * @param value The value of the parameter.
 656:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 657:    * @exception SQLException If an error occurs.
 658:    * @since 1.4
 659:    */
    void setDate(String name, Date value, Calendar cal)
      throws SQLException;
  
    /**
 664:    * This method sets the specified parameter from the given Java
 665:    * <code>java.sql.Time</code> value.
 666:    *
 667:    * @param name The name of the parameter value to set.
 668:    * @param value The value of the parameter.
 669:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 670:    * @exception SQLException If an error occurs.
 671:    * @since 1.4
 672:    */
    void setTime(String name, Time value, Calendar cal)
      throws SQLException;
  
    /**
 677:    * This method sets the specified parameter from the given Java
 678:    * <code>java.sql.Timestamp</code> value.
 679:    *
 680:    * @param name The name of the parameter value to set.
 681:    * @param value The value of the parameter.
 682:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 683:    * @exception SQLException If an error occurs.
 684:    * @since 1.4
 685:    */
    void setTimestamp(String name, Timestamp value, Calendar cal)
      throws SQLException;
  
    /**
 690:    * This method populates the specified parameter with a SQL NULL value
 691:    * for the specified type.
 692:    *
 693:    * @param name The name of the parameter to set.
 694:    * @param sqlType The SQL type identifier of the parameter from
 695:    *                <code>Types</code>
 696:    * @param typeName The name of the data type, for user defined types.
 697:    * @exception SQLException If an error occurs.
 698:    * @since 1.4
 699:    */
    void setNull(String name, int sqlType, String typeName)
      throws SQLException;
  
    /**
 704:    * This method returns the value of the specified parameter as a Java
 705:    * <code>String</code>.
 706:    *
 707:    * @param name The name of the parameter to return.
 708:    * @return The parameter value as a <code>String</code>.
 709:    * @exception SQLException If an error occurs.
 710:    * @since 1.4
 711:    */
    String getString(String name) throws SQLException;
  
    /**
 715:    * This method returns the value of the specified parameter as a Java
 716:    * <code>boolean</code>.
 717:    *
 718:    * @param name The name of the parameter to return.
 719:    * @return The parameter value as a <code>boolean</code>.
 720:    * @exception SQLException If an error occurs.
 721:    * @since 1.4
 722:    */
    boolean getBoolean(String name) throws SQLException;
  
    /**
 726:    * This method returns the value of the specified parameter as a Java
 727:    * <code>byte</code>.
 728:    *
 729:    * @param name The name of the parameter to return.
 730:    * @return The parameter value as a <code>byte</code>.
 731:    * @exception SQLException If an error occurs.
 732:    * @since 1.4
 733:    */
    byte getByte(String name) throws SQLException;
  
    /**
 37:    * This method returns the value of the specified parameter as a Java
 738:    * <code>short</code>.
 739:    *
 740:    * @param name The name of the parameter to return.
 741:    * @return The parameter value as a <code>short</code>.
 742:    * @exception SQLException If an error occurs.
 743:    * @since 1.4
 744:    */
    short getShort(String name) throws SQLException;
  
    /**
 748:    * This method returns the value of the specified parameter as a Java
 749:    * <code>int</code>.
 750:    *
 751:    * @param name The name of the parameter to return.
 752:    * @return The parameter value as a <code>int</code>.
 753:    * @exception SQLException If an error occurs.
 754:    * @since 1.4
 755:    */
    int getInt(String name) throws SQLException;
  
    /**
 759:    * This method returns the value of the specified parameter as a Java
 760:    * <code>long</code>.
 761:    *
 762:    * @param name The name of the parameter to return.
 763:    * @return The parameter value as a <code>long</code>.
 764:    * @exception SQLException If an error occurs.
 765:    * @since 1.4
 766:    */
    long getLong(String name) throws SQLException;
  
    /**
 770:    * This method returns the value of the specified parameter as a Java
 771:    * <code>float</code>.
 772:    *
 773:    * @param name The name of the parameter to return.
 774:    * @return The parameter value as a <code>float</code>.
 775:    * @exception SQLException If an error occurs.
 776:    * @since 1.4
 777:    */
    float getFloat(String name) throws SQLException;
  
    /**
 781:    * This method returns the value of the specified parameter as a Java
 782:    * <code>double</code>.
 783:    *
 784:    * @param name The name of the parameter to return.
 785:    * @return The parameter value as a <code>double</code>.
 786:    * @exception SQLException If an error occurs.
 787:    * @since 1.4
 788:    */
   double getDouble(String name) throws SQLException;
  
    /**
 792:    * This method returns the value of the specified parameter as a Java
 793:    * <code>byte</code> array.
 794:    *
 795:    * @param name The name of the parameter to return.
 796:    * @return The parameter value as a <code>byte[]</code>.
 797:    * @exception SQLException If an error occurs.
 798:    * @since 1.4
 799:    */
    byte[] getBytes(String name) throws SQLException;
  
    /**
 803:    * This method returns the value of the specified parameter as a Java
 804:    * <code>java.sql.Date</code>.
 805:    *
 806:    * @param name The name of the parameter to return.
 807:    * @return The parameter value as a <code>java.sql.Date</code>.
 808:    * @exception SQLException If an error occurs.
 809:    * @since 1.4
 810:    */
    Date getDate(String name) throws SQLException;
  
    /**
 814:    * This method returns the value of the specified parameter as a Java
 815:    * <code>java.sql.Time</code>.
 816:    *
 817:    * @param name The name of the parameter to return.
 818:    * @return The parameter value as a <code>java.sql.Time</code>.
 819:    * @exception SQLException If an error occurs.
 820:    * @since 1.4
 821:    */
    Time getTime(String name) throws SQLException;
  
    /**
 825:    * This method returns the value of the specified parameter as a Java
 826:    * <code>java.sql.Timestamp</code>.
 827:    *
 828:    * @param name The name of the parameter to return.
 829:    * @return The parameter value as a <code>java.sql.Timestamp</code>.
 830:    * @exception SQLException If an error occurs.
 831:    * @since 1.4
 832:    */
    Timestamp getTimestamp(String name) throws SQLException;
  
    /**
 836:    * This method returns the value of the specified parameter as a Java
 837:    * <code>Object</code>.
 838:    *
 839:    * @param name The name of the parameter to return.
 840:    * @return The parameter value as a <code>Object</code>.
 841:    * @exception SQLException If an error occurs.
 842:    * @since 1.4
 843:    */
    Object getObject(String name) throws SQLException;
  
    /**
 847:    * This method returns the value of the specified parameter as a Java
 848:    * <code>BigDecimal</code>.
 849:    *
 850:    * @param name The name of the parameter to return.
 851:    * @return The parameter value as a <code>BigDecimal</code>.
 852:    * @exception SQLException If an error occurs.
 853:    * @since 1.4
 854:    */
    BigDecimal getBigDecimal(String name) throws SQLException;
  
    /**
 858:    * This method returns the value of the specified parameter as a Java
 859:    * <code>Object</code> using the specified mapping for conversion from
 860:    * SQL to Java types.
 861:    *
 862:    * @param name The name of the parameter to return.
 863:    * @param map The mapping to use for conversion from SQL to Java types.
 864:    * @return The parameter value as an <code>Object</code>.
 865:    * @exception SQLException If an error occurs.
 866:    * @since 1.4
 867:    */
    Object getObject(String name, Map<String, Class<?>> map) throws SQLException;
  
    /**
 871:    * This method returns the value of the specified parameter as a Java
 872:    * <code>Ref</code>.
 873:    *
 874:    * @param name The name of the parameter to return.
 875:    * @return The parameter value as a <code>Ref</code>.
 876:    * @exception SQLException If an error occurs.
 877:    * @since 1.4
 878:    */
    Ref getRef(String name) throws SQLException;
  
    /**
 882:    * This method returns the value of the specified parameter as a Java
 883:    * <code>Blob</code>.
 884:    *
 885:    * @param name The name of the parameter to return.
 886:    * @return The parameter value as a <code>Blob</code>.
 887:    * @exception SQLException If an error occurs.
 888:    * @since 1.4
 889:    */
    Blob getBlob(String name) throws SQLException;
  
    /**
 893:    * This method returns the value of the specified parameter as a Java
 894:    * <code>Clob</code>.
 895:    *
 896:    * @param name The name of the parameter to return.
 897:    * @return The parameter value as a <code>Clob</code>.
 898:    * @exception SQLException If an error occurs.
 899:    * @since 1.4
 900:    */
    Clob getClob(String name) throws SQLException;
  
    /**
 904:    * This method returns the value of the specified parameter as a Java
 905:    * <code>Array</code>.
 906:    *
 907:    * @param name The name of the parameter to return.
 908:    * @return The parameter value as a <code>Array</code>.
 909:    * @exception SQLException If an error occurs.
 910:    * @since 1.4
 911:    */
    Array getArray(String name) throws SQLException;
  
    /**
 915:    * This method returns the value of the specified parameter as a Java
 916:    * <code>java.sql.Date</code>.
 917:    *
 918:    * @param name The name of the parameter to return.
 919:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 920:    * @return The parameter value as a <code>java.sql.Date</code>.
 921:    * @exception SQLException If an error occurs.
 922:    * @since 1.4
 923:    */
    Date getDate(String name, Calendar cal) throws SQLException;
  
    /**
 927:    * This method returns the value of the specified parameter as a Java
 928:    * <code>java.sql.Time</code>.
 929:    *
 930:    * @param name The name of the parameter to return.
 931:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 932:    * @return The parameter value as a <code>java.sql.Time</code>.
 933:    * @exception SQLException If an error occurs.
 934:    * @since 1.4
 935:    */
    Time getTime(String name, Calendar cal) throws SQLException;
  
    /**
 939:    * This method returns the value of the specified parameter as a Java
 940:    * <code>java.sql.Timestamp</code>.
 941:    *
 942:    * @param name The name of the parameter to return.
 943:    * @param cal The <code>Calendar</code> to use for timezone and locale.
 944:    * @return The parameter value as a <code>java.sql.Timestamp</code>.
 945:    * @exception SQLException If an error occurs.
 946:    * @since 1.4
 47:    */
    Timestamp getTimestamp(String name, Calendar cal)
      throws SQLException;
  
    /**
 952:    * This method returns the value of the specified parameter as a Java
 953:    * <code>java.net.URL</code>.
 954:    *
 955:    * @param name The name of the parameter to return.
 956:    * @return The parameter value as a <code>java.net.URL</code>.
 957:    * @exception SQLException If an error occurs.
 958:    * @since 1.4
 959:    */
    URL getURL(String name) throws SQLException;
  }
