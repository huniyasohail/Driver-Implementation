package java.sql.start;
  : 
   public interface DatabaseMetaData 
   {
     /**
  43:    * It is unknown whether or not the procedure returns a result.
  44:    */
     int procedureResultUnknown = 0;
   
     /**
  48:    * The procedure does not return a result.
  49:    */
     int procedureNoResult = 1;
   
     /**
  53:    * The procedure returns a result.
  54:    */
     int procedureReturnsResult = 2;
   
     /**
  58:    * The column type is unknown.
  59:    */
     int procedureColumnUnknown = 0;
   
     /**
  63:    * The column type is input.
  64:    */
     int procedureColumnIn = 1;
  
     /**
  68:    * The column type is input/output.
  69:    */
     int procedureColumnInOut = 2;
   
     /**
  73:    * The column type is output
  4:    */
     int procedureColumnOut = 4;
   
     /**
  78:    * The column is used for return values.
  79:    */
     int procedureColumnReturn = 5;
     /**
  83:    * The column is used for storing results
  84:    */
     int procedureColumnResult = 3;
   
     /**
  88:    * NULL values are not allowed.
  89:    */
     int procedureNoNulls = 0;
   
     /**
  93:    * NULL values are allowed.
  94:    */
     int procedureNullable = 1;
   
     /**
  98:    * It is unknown whether or not NULL values are allowed.
  99:    */
    int procedureNullableUnknown = 2;
  
    /**
 103:    * The column does not allow NULL
 104:    */
    int columnNoNulls = 0;
  
    /**
 8:    * The column does allow NULL
 109:    */
    int columnNullable = 1;
  
    /**
 13:    * It is unknown whether or not the column allows NULL
 114:    */
    int columnNullableUnknown = 2;
  
    /**
 118:    * The best row's scope is only guaranteed to be valid so long as the
 119:    * row is actually being used.
 120:    */
    int bestRowTemporary = 0;
  
    /**
 124:    * The best row identifier is valid to the end of the transaction.
 125:    */
    int bestRowTransaction = 1;
  
    /**
 129:    * The best row identifier is valid to the end of the session.
 130:    */
    int bestRowSession = 2;
 
    /**
 134:    * The best row may or may not be a pseudo-column.
 135:    */
    int bestRowUnknown = 0;
  
    /**
 139:    * The best row identifier is not a pseudo-column.
 140:    */
    int bestRowNotPseudo = 1;
  
    /**
 144:    * The best row identifier is a pseudo-column.
 145:    */
    int bestRowPseudo = 2;
  
    /**
 149:    * It is unknown whether or not the version column is a pseudo-column.
 150:    */
    int versionColumnUnknown = 0;
  
    /**
 154:    * The version column is not a pseudo-column
 155:    */
    int versionColumnNotPseudo = 1;
  
    /**
 159:    * The version column is a pseudo-column
 160:    */
    int versionColumnPseudo = 2;
  
    /**
 164:    * Foreign key changes are cascaded in updates or deletes.
 165:    */
    int importedKeyCascade = 0;
  
    /**
 169:    * Column may not be updated or deleted in use as a foreign key.
 170:    */
    int importedKeyRestrict = 1;
  
    /**
 174:    * When primary key is updated or deleted, the foreign key is set to NULL.
 175:    */
    int importedKeySetNull = 2;
  
    /**
 179:    * If the primary key is a foreign key, it cannot be udpated or deleted.
 180:    */
    int importedKeyNoAction = 3;
 
    /**
 84:    * If the primary key is updated or deleted, the foreign key is set to
 185:    * a default value.
 186:    */
    int importedKeySetDefault = 4;
 
    /**
 190:    * Wish I knew what this meant.
 191:    */
    int importedKeyInitiallyDeferred = 5;
  
    /**
 195:    * Wish I knew what this meant.
 196:    */
    int importedKeyInitiallyImmediate = 6;
  
    /**
 0:    * Wish I knew what this meant.
 201:    */
    int importedKeyNotDeferrable = 7;
  
    /**
 05:    * A NULL value is not allowed for this data type.
 206:    */
    int typeNoNulls = 0;
  
    /**
 210:    * A NULL value is allowed for this data type.
 211:    */
    int typeNullable = 1;
  
    /**
 215:    * It is unknown whether or not NULL values are allowed for this data type.
 216:    */
    int typeNullableUnknown = 2;
  
    /**
 20:    * Where clauses are not supported for this type.
 221:    */
    int typePredNone = 0;
  
    /**
 225:    * Only "WHERE..LIKE" style WHERE clauses are allowed on this data type.
 26:    */
    int typePredChar = 1;
  
    /**
 230:    * All WHERE clauses except "WHERE..LIKE" style are allowed on this data type.
 231:    */
    int typePredBasic = 2;
  
    /**
 235:    * Any type of WHERE clause is allowed for this data type.
 236:    */
    int typeSearchable = 3;
  
    /**
 240:    * This column contains table statistics.
 241:    */
    short tableIndexStatistic = 0;
  
    /**
 245:    * This table index is clustered.
 246:    */
    short tableIndexClustered = 1;
  
    /**
 250:    * This table index is hashed.
 251:    */
    short tableIndexHashed = 2;
  
    /**
 255:    * This table index is of another type.
 256:    */
    short tableIndexOther = 3;
  
    /**
 260:    * A NULL value is not allowed for this attribute.
 261:    */
    short attributeNoNulls = 0;
  
    /**
 5:    * A NULL value is allowed for this attribute.
 266:    */
    short attributeNullable = 1;
  
    /**
 270:    * It is unknown whether or not NULL values are allowed for this attribute.
 271:    */
    short attributeNullableUnknown = 2;
  
    int sqlStateXOpen = 1;
  
    int sqlStateSQL99 = 2;
  
    /**
 79:    * This method tests whether or not all the procedures returned by
 280:    * the <code>getProcedures</code> method can be called by this user.
 281:    *
 282:    * @return <code>true</code> if all the procedures can be called,
 283:    * <code>false</code> otherwise.
 284:    * @exception SQLException If an error occurs.
 285:    */
   boolean allProceduresAreCallable() throws SQLException;
  
    /**
 :    * This method tests whether or not all the table returned by the
 290:    * <code>getTables</code> method can be selected by this user.
 291:    *
 292:    * @return <code>true</code> if all the procedures can be called,
 293:    * <code>false</code> otherwise.
 294:    *
 295:    * @exception SQLException If an error occurs.
 296:    */
    boolean allTablesAreSelectable() throws SQLException;
  
    /**
 300:    * This method returns the URL for this database.
 301:    *
 302:    * @return The URL string for this database, or <code>null</code> if it
 303:    *         is not known.
 304:    * @exception SQLException If an error occurs.
 305:    */
    String getURL() throws SQLException;
  
    /**
 309:    * This method returns the database username for this connection.
 310:    *
 311:    * @return The database username.
 312:    * @exception SQLException If an error occurs.
 313:    */
    String getUserName() throws SQLException;
  
    /**
 317:    * This method tests whether or not the database is in read only mode.
 318:    *
 319:    * @return <code>true</code> if the database is in read only mode,
 320:    *         <code>false</code> otherwise.
 321:    * @exception SQLException If an error occurs.
 322:    */
    boolean isReadOnly() throws SQLException;
  
    /**
 326:    * This method tests whether or not NULL's sort as high values.
 327:    *
 328:    * @return <code>true</code> if NULL's sort as high values, <code>false</code>
 329:    *         otherwise.
 330:    * @exception SQLException If an error occurs.
 331:    */
    boolean nullsAreSortedHigh() throws SQLException;
  
    /**
 335:    * This method tests whether or not NULL's sort as low values.
 336:    *
 337:    * @return <code>true</code> if NULL's sort as low values, <code>false</code>
 338:    * otherwise.
 339:    * @exception SQLException If an error occurs.
 340:    */
    boolean nullsAreSortedLow() throws SQLException;
  
    /**
 44:    * This method tests whether or not NULL's sort as high values.
 345:    *
 346:    * @return <code>true</code> if NULL's sort as high values, <code>false</code>
 347:    * otherwise.
 348:    * @exception SQLException If an error occurs.
 349:    */
    boolean nullsAreSortedAtStart() throws SQLException;
  
    /**
 353:    * This method test whether or not NULL's are sorted to the end
 354:    * of the list regardless of ascending or descending sort order.
 355:    *
 356:    * @return <code>true</code> if NULL's always sort to the end,
 357:    * <code>false</code> otherwise.
 358:    * @exception SQLException If an error occurs.
 359:    */
    boolean nullsAreSortedAtEnd() throws SQLException;
  
    /**
 363:    * This method returns the name of the database product.
 364:    *
 365:    * @return The database product.
 366:    * @exception SQLException If an error occurs.
 367:    */
    String getDatabaseProductName() throws SQLException;
  
    /**
 371:    * This method returns the version of the database product.
 372:    *
 373:    * @return The version of the database product.
 374:    * @exception SQLException If an error occurs.
 375:    */
    String getDatabaseProductVersion() throws SQLException;
  
    /**
 79:    * This method returns the name of the JDBC driver.
 380:    *
 381:    * @return The name of the JDBC driver.
 382:    * @exception SQLException If an error occurs.
 383:    */
    String getDriverName() throws SQLException;
  
    /**
 87:    * This method returns the version of the JDBC driver.
 388:    *
 389:    * @return The version of the JDBC driver.
 390:    * @exception SQLException If an error occurs.
 391:    */
    String getDriverVersion() throws SQLException;
  
    /**
 395:    * This method returns the major version number of the JDBC driver.
 396:    *
 397:    * @return The major version number of the JDBC driver.
 398:    */
    int getDriverMajorVersion();
  
    /**
 402:    * This method returns the minor version number of the JDBC driver.
 403:    *
 404:    * @return The minor version number of the JDBC driver.
 405:    */
    int getDriverMinorVersion();
  
    /**
 409:    * This method tests whether or not the database uses local files to
 410:    * store tables.
 411:    *
 412:    * @return <code>true</code> if the database uses local files, 
 413:    * <code>false</code> otherwise.
 414:    *
 415:    * @exception SQLException If an error occurs.
 416:    */
    boolean usesLocalFiles() throws SQLException;
  
    /**
 420:    * This method tests whether or not the database uses a separate file for
 421:    * each table.
 422:    *
 423:    * @return <code>true</code> if the database uses a separate file for each
 424:    * table <code>false</code> otherwise.
 425:    *
 426:    * @exception SQLException If an error occurs.
 427:    */
    boolean usesLocalFilePerTable() throws SQLException;
  
    /**
 431:    * This method tests whether or not the database supports identifiers
 432:    * with mixed case.
 433:    *
 434:    * @return <code>true</code> if the database supports mixed case identifiers,
 435:    * <code>false</code> otherwise.
 436:    *
 437:    * @exception SQLException If an error occurs.
 438:    */
    boolean supportsMixedCaseIdentifiers() throws SQLException;
  
    /**
 442:    * This method tests whether or not the database treats mixed case
 443:    * identifiers as all upper case.
 444:    *
 445:    * @return <code>true</code> if the database treats all identifiers as
 446:    *         upper case, <code>false</code> otherwise.
 447:    * @exception SQLException If an error occurs.
 448:    */
    boolean storesUpperCaseIdentifiers() throws SQLException;
  
    /**
 452:    * This method tests whether or not the database treats mixed case
 453:    * identifiers as all lower case.
 454:    *
 455:    * @return <code>true</code> if the database treats all identifiers as
 456:    *         lower case, <code>false</code> otherwise.
 457:    * @exception SQLException If an error occurs.
 458:    */
    boolean storesLowerCaseIdentifiers() throws SQLException;
  
    /**
 462:    * This method tests whether or not the database stores mixed case 
 463:    * identifers even if it treats them as case insensitive.
 464:    *
 465:    * @return <code>true</code> if the database stores mixed case identifiers,
 466:    *         <code>false</code> otherwise.
 467:    * @exception SQLException If an error occurs.
 68:    */
    boolean storesMixedCaseIdentifiers() throws SQLException;
  
    /**
 472:    * This method tests whether or not the database supports quoted identifiers
 473:    * with mixed case.
 474:    *
 475:    * @return <code>true</code> if the database supports mixed case quoted
 476:    *         identifiers, <code>false</code> otherwise.
 477:    * @exception SQLException If an error occurs.
 478:    */
    boolean supportsMixedCaseQuotedIdentifiers() throws SQLException;
  
    /**
 482:    * This method tests whether or not the database treats mixed case
 483:    * quoted identifiers as all upper case.
 484:    *
 485:    * @return <code>true</code> if the database treats all quoted identifiers 
 486:    *         as upper case, <code>false</code> otherwise.
 487:    * @exception SQLException If an error occurs.
 488:    */
    boolean storesUpperCaseQuotedIdentifiers() throws SQLException;
  
    /**
 492:    * This method tests whether or not the database treats mixed case
 493:    * quoted identifiers as all lower case.
 494:    *
 495:    * @return <code>true</code> if the database treats all quoted identifiers 
 496:    *         as lower case, <code>false</code> otherwise.
 497:    * @exception SQLException If an error occurs.
 498:    */
    boolean storesLowerCaseQuotedIdentifiers() throws SQLException;
  
    /**
 502:    * This method tests whether or not the database stores mixed case 
 503:    * quoted identifers even if it treats them as case insensitive.
 504:    *
 505:    * @return <code>true</code> if the database stores mixed case quoted 
 506:    *         identifiers, <code>false</code> otherwise.
 507:    * @exception SQLException If an error occurs.
 508:    */
    boolean storesMixedCaseQuotedIdentifiers() throws SQLException;
  
    /**
 512:    * This metohd returns the quote string for SQL identifiers.
 513:    *
 514:    * @return The quote string for SQL identifers, or a space if quoting
 515:    *         is not supported.
 516:    * @exception SQLException If an error occurs.
 517:    */
    String getIdentifierQuoteString() throws SQLException;
  
    /**
 521:    * This method returns a comma separated list of all the SQL keywords in
 522:    * the database that are not in SQL92.
 523:    *
 524:    * @return The list of SQL keywords not in SQL92.
 525:    * @exception SQLException If an error occurs.
 526:    */
    String getSQLKeywords() throws SQLException;
  
    /**
 530:    * This method returns a comma separated list of math functions.
 531:    *
 532:    * @return The list of math functions.
 533:    * @exception SQLException If an error occurs.
 534:    */
    String getNumericFunctions() throws SQLException;
  
    /**
 538:    * This method returns a comma separated list of string functions.
 539:    *
 540:    * @return The list of string functions.
 541:    * @exception SQLException If an error occurs.
 542:    */
    String getStringFunctions() throws SQLException;
  
    /**
 546:    * This method returns a comma separated list of of system functions.
 547:    *
 548:    * @return A comma separated list of system functions.
 549:    * @exception SQLException If an error occurs.
 550:    */
    String getSystemFunctions() throws SQLException;
 
    /**
 4:    * This method returns comma separated list of time/date functions.
 555:    * 
 556:    * @return The list of time/date functions.
 557:    * @exception SQLException If an error occurs.
 558:    */
    String getTimeDateFunctions() throws SQLException;
  
    /**
 62:    * This method returns the string used to escape wildcards in search strings.
 563:    *
 564:    * @return The string used to escape wildcards in search strings.
 565:    * @exception SQLException If an error occurs.
 566:    */
    String getSearchStringEscape() throws SQLException;
  
    /**
 570:    * This methods returns non-standard characters that can appear in 
 571:    * unquoted identifiers.
 572:    *
 573:    * @return Non-standard characters that can appear in unquoted identifiers.
 574:    * @exception SQLException If an error occurs.
 575:    */
    String getExtraNameCharacters() throws SQLException;
  
    /**
 579:    * This method tests whether or not the database supports
 580:    * "ALTER TABLE ADD COLUMN"
 581:    *
 582:    * @return <code>true</code> if column add supported, <code>false</code>
 583:    *         otherwise.
 584:    * @exception SQLException If an error occurs.
 585:    */
    boolean supportsAlterTableWithAddColumn() throws SQLException;
  
    /**
 89:    * This method tests whether or not the database supports
 590:    * "ALTER TABLE DROP COLUMN"
 591:    *
 592:    * @return <code>true</code> if column drop supported, <code>false</code>
 593:    *         otherwise.
 594:    * @exception SQLException If an error occurs.
 595:    */
    boolean supportsAlterTableWithDropColumn() throws SQLException;
  
    /**
 599:    * This method tests whether or not column aliasing is supported.
 600:    *
 601:    * @return <code>true</code> if column aliasing is supported,
 602:    *         <code>false</code> otherwise.
 603:    * @exception SQLException If an error occurs.
 604:    */
    boolean supportsColumnAliasing() throws SQLException;
  
    /**
 8:    * This method tests whether the concatenation of a NULL and non-NULL
 609:    * value results in a NULL.  This will always be true in fully JDBC compliant
 610:    * drivers.
 611:    *
 612:    * @return <code>true</code> if concatenating NULL and a non-NULL value
 613:    *         returns a NULL, <code>false</code> otherwise.
 614:    * @exception SQLException If an error occurs.
 615:    */
    boolean nullPlusNonNullIsNull() throws SQLException;
  
    /**
 619:    * Tests whether or not CONVERT is supported.
 620:    *
 621:    * @return <code>true</code> if CONVERT is supported, <code>false</code>
 622:    *         otherwise.
 623:    * @exception SQLException If an error occurs.
 624:    */
    boolean supportsConvert() throws SQLException;
  
    /**
 28:    * This method tests whether or not CONVERT can be performed between the
 629:    * specified types.  The types are contants from <code>Types</code>.
 630:    *
 631:    * @param fromType The SQL type to convert from.
 632:    * @param toType The SQL type to convert to.
 633:    * @return <code>true</code> if the conversion can be performed,
 634:    *         <code>false</code> otherwise.
 635:    * @see Types
 636:    */
    boolean supportsConvert(int fromType, int toType) throws
        SQLException;
  
    /**
 641:    * This method tests whether or not table correlation names are 
 642:    * supported.  This will be always be <code>true</code> in a fully JDBC
 643:    * compliant driver.
 644:    *
 645:    * @return <code>true</code> if table correlation names are supported,
 646:    *         <code>false</code> otherwise.
 647:    * @exception SQLException If an error occurs.
 648:    */
    boolean supportsTableCorrelationNames() throws SQLException;
  
    /**
 52:    * This method tests whether correlation names must be different from the
 653:    * name of the table.
 654:    *
 655:    * @return <code>true</code> if the correlation name must be different from
 656:    *         the table name, <code>false</code> otherwise.
 657:    * @exception SQLException If an error occurs.
 658:    */
    boolean supportsDifferentTableCorrelationNames() throws SQLException;
  
    /**
 662:    * This method tests whether or not expressions are allowed in an
 663:    * ORDER BY lists.
 664:    *
 665:    * @return <code>true</code> if expressions are allowed in ORDER BY
 666:    *         lists, <code>false</code> otherwise.
 667:    * @exception SQLException If an error occurs.
 668:    */
    boolean supportsExpressionsInOrderBy() throws SQLException;
  
    /**
 672:    * This method tests whether or ORDER BY on a non-selected column is
 673:    * allowed.
 674:    *
 675:    * @return <code>true</code> if a non-selected column can be used in an
 676:    *         ORDER BY, <code>false</code> otherwise.
 677:    * @exception SQLException If an error occurs.
 678:    */
    boolean supportsOrderByUnrelated() throws SQLException;
  
    /**
 82:    * This method tests whether or not GROUP BY is supported.
 683:    *
 684:    * @return <code>true</code> if GROUP BY is supported, <code>false</code>
 685:    *         otherwise.
 686:    * @exception SQLException If an error occurs.
 687:    */
    boolean supportsGroupBy() throws SQLException;
  
    /**
 691:    * This method tests whether GROUP BY on a non-selected column is
 692:    * allowed.
 693:    *
 694:    * @return <code>true</code> if a non-selected column can be used in a
 695:    *         GROUP BY, <code>false</code> otherwise.
 696:    * @exception SQLException If an error occurs.
 697:    */
    boolean supportsGroupByUnrelated() throws SQLException;
  
    /**
 701:    * This method tests whether or not a GROUP BY can add columns not in the
 702:    * select if it includes all the columns in the select.
 703:    *
 04:    * @return <code>true</code> if GROUP BY an add columns provided it includes
 705:    *         all columns in the select, <code>false</code> otherwise.
 706:    * @exception SQLException If an error occurs.
 707:    */
    boolean supportsGroupByBeyondSelect() throws SQLException;
  
    /**
 1:    * This method tests whether or not the escape character is supported in
 712:    * LIKE expressions.  A fully JDBC compliant driver will always return
 713:    * <code>true</code>.
 714:    *
 715:    * @return <code>true</code> if escapes are supported in LIKE expressions,
 716:    *         <code>false</code> otherwise.
 717:    * @exception SQLException If an error occurs.
 718:    */
    boolean supportsLikeEscapeClause() throws SQLException;
  
    /**
 722:    * This method tests whether multiple result sets for a single statement are
 723:    * supported.
 724:    *
 725:    * @return <code>true</code> if multiple result sets are supported for a 
 726:    *         single statement, <code>false</code> otherwise.
 727:    * @exception SQLException If an error occurs.
 728:    */
    boolean supportsMultipleResultSets() throws SQLException;
  
    /**
 732:    * This method test whether or not multiple transactions may be open
 733:    * at once, as long as they are on different connections.
 734:    *
 735:    * @return <code>true</code> if multiple transactions on different
 736:    *         connections are supported, <code>false</code> otherwise.
 737:    * @exception SQLException If an error occurs.
 738:    */
    boolean supportsMultipleTransactions() throws SQLException;
  
    /**
 742:    * This method tests whether or not columns can be defined as NOT NULL.  A
 743:    * fully JDBC compliant driver always returns <code>true</code>.
 744:    *
 745:    * @return <code>true</code> if NOT NULL columns are supported,
 746:    *         <code>false</code> otherwise.
 747:    * @exception SQLException If an error occurs.
 748:    */
    boolean supportsNonNullableColumns() throws SQLException;
  
    /**
 752:    * This method tests whether or not the minimum grammer for ODBC is supported.
 753:    * A fully JDBC compliant driver will always return <code>true</code>.
 754:    *
 755:    * @return <code>true</code> if the ODBC minimum grammar is supported,
 756:    *         <code>false</code> otherwise.
 57:    * @exception SQLException If an error occurs.
 758:    */
    boolean supportsMinimumSQLGrammar() throws SQLException;
  
    /**
 :    * This method tests whether or not the core grammer for ODBC is supported.
 3:    *
 764:    * @return <code>true</code> if the ODBC core grammar is supported,
 765:    *         <code>false</code> otherwise.
 766:    * @exception SQLException If an error occurs.
 767:    */
    boolean supportsCoreSQLGrammar() throws SQLException;
  
    /**
 1:    * This method tests whether or not the extended grammer for ODBC is supported.
 772:    *
 773:    * @return <code>true</code> if the ODBC extended grammar is supported,
 774:    *         <code>false</code> otherwise.
 775:    * @exception SQLException If an error occurs.
 776:    */
    boolean supportsExtendedSQLGrammar() throws SQLException;
  
    /**
 780:    * This method tests whether or not the ANSI92 entry level SQL
 781:    * grammar is supported.  A fully JDBC compliant drivers must return
 782:    * <code>true</code>.
 783:    *
 784:    * @return <code>true</code> if the ANSI92 entry level SQL grammar is
 785:    *         supported, <code>false</code> otherwise.
 786:    * @exception SQLException If an error occurs.
 787:    */
    boolean supportsANSI92EntryLevelSQL() throws SQLException;
  
    /**
 791:    * This method tests whether or not the ANSI92 intermediate SQL
 792:    * grammar is supported.  
 793:    *
 794:    * @return <code>true</code> if the ANSI92 intermediate SQL grammar is
 795:    *         supported, <code>false</code> otherwise.
 796:    * @exception SQLException If an error occurs.
 797:    */
    boolean supportsANSI92IntermediateSQL() throws SQLException;
    /**
 01:    * This method tests whether or not the ANSI92 full SQL
 802:    * grammar is supported.  
 803:    *
 804:    * @return <code>true</code> if the ANSI92 full SQL grammar is
 805:    *         supported, <code>false</code> otherwise.
 806:    * @exception SQLException If an error occurs.
 807:    */
    boolean supportsANSI92FullSQL() throws SQLException;
  
    /**
 811:    * This method tests whether or not the SQL integrity enhancement
 812:    * facility is supported.
 813:    *
 814:    * @return <code>true</code> if the integrity enhancement facility is
 815:    *         supported, <code>false</code> otherwise.
 816:    * @exception SQLException If an error occurs.
 817:    */
    boolean supportsIntegrityEnhancementFacility() throws SQLException;
  
    /**
 821:    * This method tests whether or not the database supports outer joins.
 822:    *
 823:    * @return <code>true</code> if outer joins are supported, <code>false</code>
 824:    *         otherwise.
 825:    * @exception SQLException If an error occurs.
 826:    */
    boolean supportsOuterJoins() throws SQLException;
  
    /**
 30:    * This method tests whether or not the database supports full outer joins.
 831:    *
 832:    * @return <code>true</code> if full outer joins are supported, 
 833:    *         <code>false</code> otherwise.
 834:    * @exception SQLException If an error occurs.
 835:    */
    boolean supportsFullOuterJoins() throws SQLException;
  
    /**
 839:    * This method tests whether or not the database supports limited outer joins.
 840:    *
 841:    * @return <code>true</code> if limited outer joins are supported, 
 842:    *         <code>false</code> otherwise.
 843:    * @exception SQLException If an error occurs.
 844:    */
    boolean supportsLimitedOuterJoins() throws SQLException;
  
    /**
 848:    * This method returns the vendor's term for "schema".
 849:    *
 850:    * @return The vendor's term for schema.
 851:    * @exception SQLException if an error occurs.
 852:    */
    String getSchemaTerm() throws SQLException;
  
    /**
 856:    * This method returns the vendor's term for "procedure".
 857:    *
 858:    * @return The vendor's term for procedure.
 859:    * @exception SQLException if an error occurs.
 860:    */
    String getProcedureTerm() throws SQLException;
  
    /**
 64:    * This method returns the vendor's term for "catalog".
 865:    *
 866:    * @return The vendor's term for catalog.
 867:    * @exception SQLException if an error occurs.
 868:    */
    String getCatalogTerm() throws SQLException;
  
    /**
 72:    * This method tests whether a catalog name appears at the beginning of
 873:    * a fully qualified table name.
 874:    *
 875:    * @return <code>true</code> if the catalog name appears at the beginning,
 876:    *         <code>false</code> if it appears at the end.
 877:    * @exception SQLException If an error occurs.
 878:    */
    boolean isCatalogAtStart() throws SQLException;
  
    /**
 882:    * This method returns the separator between the catalog name and the
 883:    * table name.
 884:    *
 885:    * @return The separator between the catalog name and the table name.
 886:    * @exception SQLException If an error occurs.
 887:    */
    String getCatalogSeparator() throws SQLException;
  
    /**
 91:    * This method tests whether a catalog name can appear in a data
 892:    * manipulation statement.
 893:    *
 894:    * @return <code>true</code> if a catalog name can appear in a data
 895:    *         manipulation statement, <code>false</code> otherwise.
 896:    * @exception SQLException If an error occurs.
 897:    */
    boolean supportsSchemasInDataManipulation() throws SQLException;
  
    /**
 901:    * This method tests whether a catalog name can appear in a procedure
 902:    * call
 903:    *
 904:    * @return <code>true</code> if a catalog name can appear in a procedure
 905:    *         call, <code>false</code> otherwise.
 906:    * @exception SQLException If an error occurs.
 907:    */
    boolean supportsSchemasInProcedureCalls() throws SQLException;
  
    /**
 911:    * This method tests whether a catalog name can appear in a table definition.
 912:    *
 913:    * @return <code>true</code> if a catalog name can appear in a table
 914:    *         definition, <code>false</code> otherwise.
 915:    * @exception SQLException If an error occurs.
 916:    */
    boolean supportsSchemasInTableDefinitions() throws SQLException;
  
    /**
 920:    * This method tests whether a catalog name can appear in an index definition.
 921:    *
 922:    * @return <code>true</code> if a catalog name can appear in an index
 923:    *         definition, <code>false</code> otherwise.
 924:    * @exception SQLException If an error occurs.
 925:    */
    boolean supportsSchemasInIndexDefinitions() throws SQLException;
  
    /**
 929:    * This method tests whether a catalog name can appear in privilege definitions.
 930:    *
 931:    * @return <code>true</code> if a catalog name can appear in privilege
 932:    *         definition, <code>false</code> otherwise.
 933:    * @exception SQLException If an error occurs.
 934:    */
    boolean supportsSchemasInPrivilegeDefinitions() throws SQLException;
   /**
 938:    * This method tests whether a catalog name can appear in a data
 939:    * manipulation statement.
 940:    *
 941:    * @return <code>true</code> if a catalog name can appear in a data
 942:    *         manipulation statement, <code>false</code> otherwise.
 943:    * @exception SQLException If an error occurs.
 944:    */
    boolean supportsCatalogsInDataManipulation() throws SQLException;
  
    /**
 948:    * This method tests whether a catalog name can appear in a procedure
 949:    * call
 950:    *
 951:    * @return <code>true</code> if a catalog name can appear in a procedure
 952:    *         call, <code>false</code> otherwise.
 953:    * @exception SQLException If an error occurs.
 954:    */
    boolean supportsCatalogsInProcedureCalls() throws SQLException;
  
    /**
 958:    * This method tests whether a catalog name can appear in a table definition.
 959:    *
 960:    * @return <code>true</code> if a catalog name can appear in a table
 961:    *         definition, <code>false</code> otherwise.
 962:    * @exception SQLException If an error occurs.
 963:    */
    boolean supportsCatalogsInTableDefinitions() throws SQLException;
  
    /**
 967:    * This method tests whether a catalog name can appear in an index definition.
 968:    *
 969:    * @return <code>true</code> if a catalog name can appear in an index
 970:    *         definition, <code>false</code> otherwise.
 971:    * @exception SQLException If an error occurs.
 972:    */
    boolean supportsCatalogsInIndexDefinitions() throws SQLException;
  
    /**
 6:    * This method tests whether a catalog name can appear in privilege definitions.
 977:    *
 978:    * @return <code>true</code> if a catalog name can appear in privilege
 979:    *         definition, <code>false</code> otherwise.
 980:    * @exception SQLException If an error occurs.
 981:    */
    boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException;
  
    /**
 85:    * This method tests whether or not that database supports positioned
 986:    * deletes.
 987:    *
 988:    * @return <code>true</code> if positioned deletes are supported,
 989:    *         <code>false</code> otherwise.
 990:    * @exception SQLException If an error occurs.
 991:    */
    boolean supportsPositionedDelete() throws SQLException;
  
    /**
 995:    * This method tests whether or not that database supports positioned
 996:    * updates.
 997:    *
 998:    * @return <code>true</code> if positioned updates are supported,
 999:    *         <code>false</code> otherwise.
1000:    * @exception SQLException If an error occurs.
1001:    */
   boolean supportsPositionedUpdate() throws SQLException;
 
   /**
1005:    * This method tests whether or not SELECT FOR UPDATE is supported by the
1006:    * database.
1007:    *
1008:    * @return <code>true</code> if SELECT FOR UPDATE is supported 
1009:    *         <code>false</code> otherwise.
1010:    * @exception SQLException If an error occurs.
1011:    */
   boolean supportsSelectForUpdate() throws SQLException;
 
   /**
1015:    * This method tests whether or not stored procedures are supported on
1016:    * this database.
1017:    *
1018:    * @return <code>true</code> if stored procedures are supported,
1019:    *         <code>false</code> otherwise.
1020:    * @exception SQLException If an error occurs.
1021:    */
   boolean supportsStoredProcedures() throws SQLException;
 
   /**
1025:    * This method tests whether or not subqueries are allowed in comparisons.
1026:    * A fully JDBC compliant driver will always return <code>true</code>.
1027:    *
1028:    * @return <code>true</code> if subqueries are allowed in comparisons,
1029:    *         <code>false</code> otherwise.
1030:    * @exception SQLException If an error occurs.
1031:    */
   boolean supportsSubqueriesInComparisons() throws SQLException;
 
   /**
1035:    * This method tests whether or not subqueries are allowed in exists
1036:    * expressions.  A fully JDBC compliant driver will always return
1037:    * <code>true</code>.
1038:    *
1039:    * @return <code>true</code> if subqueries are allowed in exists 
1040:    *         expressions, <code>false</code> otherwise.
1041:    * @exception SQLException If an error occurs.
1042:    */
   boolean supportsSubqueriesInExists() throws SQLException;
/**
1046:    * This method tests whether subqueries are allowed in IN statements.
1047:    * A fully JDBC compliant driver will always return <code>true</code>.
1048:    *
1049:    * @return <code>true</code> if the driver supports subqueries in IN
1050:    *         statements, <code>false</code> otherwise.
1051:    * @exception SQLException If an error occurs.
1052:    */
   boolean supportsSubqueriesInIns() throws SQLException;

      /**
1056:    * This method tests whether or not subqueries are allowed in quantified
1057:    * expressions.  A fully JDBC compliant driver will always return
1058:    * <code>true</code>.
1059:    *
1060:    * @return <code>true</code> if subqueries are allowed in quantified 
1061:    *         expressions, <code>false</code> otherwise.
1062:    * @exception SQLException If an error occurs.
1063:    */
   boolean supportsSubqueriesInQuantifieds() throws SQLException;
 /**
1067:    * This method test whether or not correlated subqueries are allowed. A
1068:    * fully JDBC compliant driver will always return <code>true</code>.
1069:    *
1070:    * @return <code>true</code> if correlated subqueries are allowed,
1071:    *         <code>false</code> otherwise.
1072:    * @exception SQLException If an error occurs.
1073:    */
   boolean supportsCorrelatedSubqueries() throws SQLException;
  /**
1077:    * This method tests whether or not the UNION statement is supported.
1078:    *
1079:    * @return <code>true</code> if UNION is supported, <code>false</code>
1080:    *         otherwise.
1081:    * @exception SQLException If an error occurs.
1082:    */
   boolean supportsUnion() throws SQLException;
   /**
1086:    * This method tests whether or not the UNION ALL statement is supported.
1087:    *
1088:    * @return <code>true</code> if UNION ALL is supported, <code>false</code>
1089:    *         otherwise.
1090:    * @exception SQLException If an error occurs.
1091:    */
   boolean supportsUnionAll() throws SQLException;
 
   /**
5:    * This method tests whether or not the database supports cursors
1096:    * remaining open across commits.
1097:    *
1098:    * @return <code>true</code> if cursors can remain open across commits,
1099:    *         <code>false</code> otherwise.
1100:    * @exception SQLException If an error occurs.
1101:    */
   boolean supportsOpenCursorsAcrossCommit() throws SQLException;
 
   /**
1105:    * This method tests whether or not the database supports cursors
1106:    * remaining open across rollbacks.
1107:    *
1108:    * @return <code>true</code> if cursors can remain open across rollbacks,
1109:    *         <code>false</code> otherwise.
1110:    * @exception SQLException If an error occurs.
1111:    */
   boolean supportsOpenCursorsAcrossRollback() throws SQLException;
 
   /**
1115:    * This method tests whether or not the database supports statements
1116:    * remaining open across commits.
1117:    *
1118:    * @return <code>true</code> if statements can remain open across commits,
1119:    *         <code>false</code> otherwise.
1120:    * @exception SQLException If an error occurs.
1121:    */
   boolean supportsOpenStatementsAcrossCommit() throws SQLException;
 
   /**
1125:    * This method tests whether or not the database supports statements
1126:    * remaining open across rollbacks.
1127:    *
1128:    * @return <code>true</code> if statements can remain open across rollbacks,
1129:    *         <code>false</code> otherwise.
1130:    * @exception SQLException If an error occurs.
1131:    */
boolean supportsOpenStatementsAcrossRollback() throws SQLException;
 
  /**
1135:    * This method returns the number of hex characters allowed in an inline
1136:    * binary literal.
1137:    *
1138:    * @return The number of hex characters allowed in a binary literal, 0 meaning
1139:    *         either an unknown or unlimited number.
1140:    * @exception SQLException If an error occurs.
1141:    */
  int getMaxBinaryLiteralLength() throws SQLException;
 
   /**
1145:    * This method returns the maximum length of a character literal.
1146:    * 
1147:    * @return The maximum length of a character literal.
1148:    * @exception SQLException If an error occurs.
1149:    */
   int getMaxCharLiteralLength() throws SQLException;
 
   /**
53:    * This method returns the maximum length of a column name.
1154:    *
1155:    * @return The maximum length of a column name.
1156:    * @exception SQLException If an error occurs.
1157:    */
   int getMaxColumnNameLength() throws SQLException;
 
   /**
1161:    * This method returns the maximum number of columns in a GROUP BY statement.
1162:    *
1163:    * @return The maximum number of columns in a GROUP BY statement.
1164:    * @exception SQLException If an error occurs.
1165:    */
   int getMaxColumnsInGroupBy() throws SQLException;
 
   /**
1169:    * This method returns the maximum number of columns in an index.
1170:    *
1171:    * @return The maximum number of columns in an index.
1172:    * @exception SQLException If an error occurs.
1173:    */
   int getMaxColumnsInIndex() throws SQLException;

   /**
1177:    * This method returns the maximum number of columns in an ORDER BY statement.
1178:    *
1179:    * @return The maximum number of columns in an ORDER BY statement.
1180:    * @exception SQLException If an error occurs.
1181:    */
   int getMaxColumnsInOrderBy() throws SQLException;
 
   /**
185:    * This method returns the maximum number of columns in a SELECT statement.
1186:    *
1187:    * @return The maximum number of columns in a SELECT statement.
1188:    * @exception SQLException If an error occurs.
1189:    */
   int getMaxColumnsInSelect() throws SQLException;
 
   /**
193:    * This method returns the maximum number of columns in a table.
1194:    *
1195:    * @return The maximum number of columns in a table.
1196:    * @exception SQLException If an error occurs.
1197:    */
   int getMaxColumnsInTable() throws SQLException;
 
   /**
1201:    * This method returns the maximum number of connections this client
1202:    * can have to the database.
1203:    *
1204:    * @return The maximum number of database connections.
1205:    * @SQLException If an error occurs.
1206:    */
   int getMaxConnections() throws SQLException;
 
   /**
1210:    * This method returns the maximum length of a cursor name.
1211:    *
1212:    * @return The maximum length of a cursor name.
1213:    * @exception SQLException If an error occurs.
1214:    */
   int getMaxCursorNameLength() throws SQLException;
   /**
1218:    * This method returns the maximum length of an index.
1219:    *
1220:    * @return The maximum length of an index.
1221:    * @exception SQLException If an error occurs.
1222:    */
   int getMaxIndexLength() throws SQLException;
 
   /**
26:    * This method returns the maximum length of a schema name.
1227:    *
1228:    * @return The maximum length of a schema name.
1229:    * @exception SQLException If an error occurs.
1230:    */
   int getMaxSchemaNameLength() throws SQLException;
 
   /**
1234:    * This method returns the maximum length of a procedure name.
1235:    *
1236:    * @return The maximum length of a procedure name.
1237:    * @exception SQLException If an error occurs.
1238:    */
   int getMaxProcedureNameLength() throws SQLException;
 
   /**
1242:    * This method returns the maximum length of a catalog name.
1243:    *
1244:    * @return The maximum length of a catalog name.
1245:    * @exception SQLException If an error occurs.
1246:    */
   int getMaxCatalogNameLength() throws SQLException;
 
   /**
1250:    * This method returns the maximum size of a row in bytes.
1251:    *
1252:    * @return The maximum size of a row.
1253:    * @exception SQLException If an error occurs.
1254:    */
   int getMaxRowSize() throws SQLException;
 
   /**
1258:    * This method tests whether or not the maximum row size includes BLOB's
1259:    *
1260:    * @return <code>true</code> if the maximum row size includes BLOB's,
1261:    *         <code>false</code> otherwise.
1262:    * @exception SQLException If an error occurs.
1263:    */
   boolean doesMaxRowSizeIncludeBlobs() throws SQLException;
 
   /**
1267:    * This method includes the maximum length of a SQL statement.
1268:    *
1269:    * @return The maximum length of a SQL statement.
1270:    * @exception SQLException If an error occurs.
1271:    */
   int getMaxStatementLength() throws SQLException;
 
   /**
1275:    * This method returns the maximum number of statements that can be
1276:    * active at any time.
1277:    *
1278:    * @return The maximum number of statements that can be active at any time.
1279:    * @exception SQLException If an error occurs.
1280:    */
   int getMaxStatements() throws SQLException;
 
   /**
1284:    * This method returns the maximum length of a table name.
1285:    *
1286:    * @return The maximum length of a table name.
1287:    * @exception SQLException If an error occurs.
1288:    */
   int getMaxTableNameLength() throws SQLException;
 
   /**
1292:    * This method returns the maximum number of tables that may be referenced
1293:    * in a SELECT statement.
1294:    *
1295:    * @return The maximum number of tables allowed in a SELECT statement.
1296:    * @exception SQLException If an error occurs.
1297:    */
   int getMaxTablesInSelect() throws SQLException;
 
   /**
1301:    * This method returns the maximum length of a user name.
1302:    *
1303:    * @return The maximum length of a user name.
1304:    * @exception SQLException If an error occurs.
1305:    */
   int getMaxUserNameLength() throws SQLException;
 
   /**
1309:    * This method returns the default transaction isolation level of the
1310:    * database.
1311:    *
1312:    * @return The default transaction isolation level of the database.
1313:    * @exception SQLException If an error occurs.
1314:    * @see Connection
1315:    */
   int getDefaultTransactionIsolation() throws SQLException;
 
   /**
1319:    * This method tests whether or not the database supports transactions.
1320:    *
1321:    * @return <code>true</code> if the database supports transactions,
1322:    *         <code>false</code> otherwise.
1323:    * @exception SQLException If an error occurs.
1324:    */
   boolean supportsTransactions() throws SQLException;
 
   /**
1328:    * This method tests whether or not the database supports the specified
1329:    * transaction isolation level.
1330:    *
331:    * @param level The transaction isolation level.
1332:    *
1333:    * @return <code>true</code> if the specified transaction isolation level
1334:    *         is supported, <code>false</code> otherwise.
1335:    * @exception SQLException If an error occurs.
1336:    */
   boolean supportsTransactionIsolationLevel(int level) throws
       SQLException;
 
   /**
341:    * This method tests whether or not DDL and DML statements allowed within 
1342:    * the same transaction.
1343:    *
1344:    * @return <code>true</code> if DDL and DML statements are allowed in the
1345:    *         same transaction, <code>false</code> otherwise.
1346:    * @exception SQLException If an error occurs.
1347:    */
   boolean supportsDataDefinitionAndDataManipulationTransactions()
       throws SQLException;
 
   /**
1352:    * This method tests whether or not only DML statement are allowed
1353:    * inside a transaction.
1354:    *
1355:    * @return <code>true</code> if only DML statements are allowed in
1356:    *         transactions, <code>false</code> otherwise.
1357:    * @exception SQLException If an error occurs.
1358:    */
   boolean supportsDataManipulationTransactionsOnly() throws
       SQLException;
 
   /**
1363:    * This method tests whether or not a DDL statement will cause the
1364:    * current transaction to be automatically committed.
1365:    *
1366:    * @return <code>true</code> if DDL causes an immediate transaction commit,
1367:    *         <code>false</code> otherwise.
1368:    * @exception SQLException If an error occurs.
1369:    */
   boolean dataDefinitionCausesTransactionCommit() throws SQLException;
 
   /**
1373:    * This method tests whether or not DDL statements are ignored in
1374:    * transactions.
1375:    *
1376:    * @return <code>true</code> if DDL statements are ignored in transactions,
1377:    *         <code>false</code> otherwise.
1378:    * @exception SQLException If an error occurs.
1379:    */
   boolean dataDefinitionIgnoredInTransactions() throws SQLException;
   /**
1383:    * This method returns a list of all the stored procedures matching the
1384:    * specified pattern in the given schema and catalog.  This is returned
385:    * a <code>ResultSet</code> with the following columns:
1386:    * <p>
1387:    * <ol>
1388:    * <li>PROCEDURE_CAT - The catalog the procedure is in, which may be 
1389:    * <code>null</code>.</li>
1390:    * <li>PROCEDURE_SCHEM - The schema the procedures is in, which may be
1391:    * <code>null</code>.</li>
1392:    * <li>PROCEDURE_NAME - The name of the procedure.</li>
1393:    * <li>Unused</li>
1394:    * <li>Unused</li>
1395:    * <li>Unused</li>
1396:    * <li>REMARKS - A description of the procedure</li>
1397:    * <li>PROCEDURE_TYPE - Indicates the return type of the procedure, which 
1398:    * is one of the contstants defined in this class 
1399:    * (<code>procedureResultUnknown</code>, <code>procedureNoResult</code>, or
1400:    * <code>procedureReturnsResult</code>).</li>
1401:    * </ol>
1402:    *
1403:    * @param catalog The name of the catalog to return stored procedured from,
1404:    *        or "" to return procedures from all catalogs.
1405:    * @param schemaPattern A schema pattern for the schemas to return stored
1406:    *        procedures from, or "" to return procedures from all schemas.
1407:    * @param procedurePattern The pattern of procedure names to return.
1408:    * @returns A <code>ResultSet</code> with all the requested procedures.
1409:    * @exception SQLException If an error occurs.
1410:    */
   ResultSet getProcedures(String catalog, String schemaPattern, String
       procedurePattern) throws SQLException;
 
   /**
1415:    * This method returns a list of the parameter and result columns for
1416:    * the requested stored procedures.  This is returned in the form of a
1417:    * <code>ResultSet</code> with the following columns:
1418:    * <p>
1419:    * <ol>
1420:    * <li>PROCEDURE_CAT - The catalog the procedure is in, which may be 
1421:    * <code>null</code>.</li>
1422:    * <li>PROCEDURE_SCHEM - The schema the procedures is in, which may be
1423:    * <code>null</code>.</li>
1424:    * <li>PROCEDURE_NAME - The name of the procedure.</li>
1425:    * <li>COLUMN_NAME - The name of the column</li>
1426:    * <li>COLUMN_TYPE - The type of the column, which will be one of the
1427:    * contants defined in this class (<code>procedureColumnUnknown</code>,
1428:    * <code>procedureColumnIn</code>, <code>procedureColumnInOut</code>,
1429:    * <code>procedureColumnOut</code>, <code>procedureColumnReturn</code>,
1430:    * or <code>procedureColumnResult</code>).</li>
1431:    * <li>DATA_TYPE - The SQL type of the column. This is one of the constants
1432:    * defined in <code>Types</code>.</li>
1433:    * <li>TYPE_NAME - The string name of the data type for this column.</li>
1434:    * <li>PRECISION - The precision of the column.</li>
1435:    * <li>LENGTH - The length of the column in bytes</li>
1436:    * <li>SCALE - The scale of the column.</li>
1437:    * <li>RADIX - The radix of the column.</li>
1438:    * <li>NULLABLE - Whether or not the column is NULLABLE.  This is one of
1439:    * the constants defined in this class (<code>procedureNoNulls</code>,
1440:    * <code>procedureNullable</code>, or <code>procedureNullableUnknown</code>)</li>
1441:    * <li>REMARKS - A description of the column.</li>
1442:    * </ol>
1443:    *
1444:    * @param catalog The name of the catalog to return stored procedured from,
1445:    *        or "" to return procedures from all catalogs.
1446:    * @param schemaPattern A schema pattern for the schemas to return stored
1447:    *        procedures from, or "" to return procedures from all schemas.
1448:    * @param procedurePattern The pattern of procedures names to return.
1449:    * @param columnPattern The pattern of column names to return.
1450:    * @returns A <code>ResultSet</code> with all the requested procedures.
1451:    * @exception SQLException If an error occurs.
1452:    */
   ResultSet getProcedureColumns(String catalog, String schemaPattern,
       String procedurePattern, String columnPattern) throws
       SQLException;
 
   /**
1458:    * This method returns a list of the requested table as a   
1459:    * <code>ResultSet</code> with the following columns:
1460:    *
1461:    * <ol>
1462:    * <li>TABLE_CAT - The catalog the table is in, which may be <code>null</code>.</li>
1463:    * <li>TABLE_SCHEM - The schema the table is in, which may be <code>null</code>.</li>
1464:    * <li>TABLE_NAME - The name of the table.</li>
1465:    * <li>TABLE_TYPE - A string describing the table type.  This will be one
1466:    * of the values returned by the <code>getTableTypes()</code> method.</li>
467:    * <li>REMARKS - Comments about the table.</li>
1468:    * </ol>
1469:    * 
1470:    * @param catalog The name of the catalog to return tables from,
1471:    *        or "" to return tables from all catalogs.
1472:    * @param schemaPattern A schema pattern for the schemas to return tables
1473:    *        from, or "" to return tables from all schemas.
1474:    * @param tablePattern The pattern of table names to return.
1475:    * @param types The list of table types to include; null returns all types.
1476:    * @returns A <code>ResultSet</code> with all the requested tables.
1477:    * @exception SQLException If an error occurs.
1478:    */
   ResultSet getTables(String catalog, String schemaPattern, String
       tablePattern, String[] types) throws SQLException;
 
   /**
1483:    * This method returns the list of database schemas as a 
1484:    * <code>ResultSet</code>, with one column - TABLE_SCHEM - that is the
1485:    * name of the schema.
1486:    *
1487:    * @return A <code>ResultSet</code> with all the requested schemas.
1488:    * @exception SQLException If an error occurs.
1489:    */
   ResultSet getSchemas() throws SQLException;

   /**
1493:    * This method returns the list of database catalogs as a
1494:    * <code>ResultSet</code> with one column - TABLE_CAT - that is the
1495:    * name of the catalog.
1496:    *
1497:    * @return A <code>ResultSet</code> with all the requested catalogs.
1498:    * @exception SQLException If an error occurs.
1499:    */
   ResultSet getCatalogs() throws SQLException;
 
   /**
1503:    * This method returns the list of database table types as a
1504:    * <code>ResultSet</code> with one column - TABLE_TYPE - that is the
1505:    * name of the table type.
1506:    *
1507:    * @return A <code>ResultSet</code> with all the requested table types.
1508:    * @exception SQLException If an error occurs.
1509:    */
   ResultSet getTableTypes() throws SQLException;
 
   /**
1513:    * This method returns a list of the tables columns for
1514:    * the requested tables.  This is returned in the form of a
1515:    * <code>ResultSet</code> with the following columns:
1516:    * <p>
1517:    * <ol>
1518:    * <li>TABLE_CAT - The catalog the table is in, which may be 
1519:    * <code>null</code>.</li>
1520:    * <li>TABLE_SCHEM - The schema the tables is in, which may be
1521:    * <code>null</code>.</li>
1522:    * <li>TABLE_NAME - The name of the table.</li>
1523:    * <li>COLUMN_NAME - The name of the column</li>
1524:    * <li>DATA_TYPE - The SQL type of the column. This is one of the constants
1525:    * defined in <code>Types</code>.</li>
1526:    * <li>TYPE_NAME - The string name of the data type for this column.</li>
1527:    * <li>COLUMN_SIZE - The size of the column.</li>
1528:    * <li>Unused</li>
1529:    * <li>NUM_PREC_RADIX - The radix of the column.</li>
1530:    * <li>NULLABLE - Whether or not the column is NULLABLE.  This is one of
1531:    * the constants defined in this class (<code>tableNoNulls</code>,
1532:    * <code>tableNullable</code>, or <code>tableNullableUnknown</code>)</li>
1533:    * <li>REMARKS - A description of the column.</li>
1534:    * <li>COLUMN_DEF - The default value for the column, may be <code>null</code>.</li>
1535:    * <li>SQL_DATA_TYPE - Unused</li>
1536:    * <li>SQL_DATETIME_SUB - Unused</li>
1537:    * <li>CHAR_OCTET_LENGTH - For character columns, the maximum number of bytes
1538:    * in the column.</li>
1539:    * <li>ORDINAL_POSITION - The index of the column in the table.</li>
1540:    * <li>IS_NULLABLE - "NO" means no, "YES" means maybe, and an empty string
1541:    * means unknown.</li>
1542:    * </ol>
1543:    *
1544:    * @param catalog The name of the catalog to return table from,
1545:    * or "" to return tables from all catalogs.
1546:    * @param schemaPattern A schema pattern for the schemas to return 
1547:    * tables from, or "" to return tables from all schemas.
1548:    * @param tablePattern The pattern of table names to return.
1549:    * @param columnPattern The pattern of column names to return.
1550:    * @returns A <code>ResultSet</code> with all the requested tables.
1551:    * @exception SQLException If an error occurs.
1552:    */
   ResultSet getColumns(String catalog, String schemaPattern, String
       tablePattern, String columnPattern) throws SQLException;
 
   /**
1557:    * This method returns the access rights that have been granted to the
1558:    * requested columns.  This information is returned as a <code>ResultSet</code>
1559:    * with the following columns:
560:    *
1561:    * <ol>
1562:    * <li>TABLE_CAT - The catalog the table is in, which may be 
1563:    * <code>null</code>.</li>
1564:    * <li>TABLE_SCHEM - The schema the tables is in, which may be
1565:    * <code>null</code>.</li>
1566:    * <li>TABLE_NAME - The name of the table.</li>
1567:    * <li>COLUMN_NAME - The name of the column.</li>
1568:    * <li>GRANTOR - The entity that granted the access.</li>
1569:    * <li>GRANTEE - The entity granted the access.</li>
1570:    * <li>PRIVILEGE - The name of the privilege granted.</li>
1571:    * <li>IS_GRANTABLE - "YES" if the grantee can grant the privilege to
1572:    * others, "NO" if not, and <code>null</code> if unknown.</li>
1573:    * </ol>
1574:    *
1575:    * @param catalog The catalog to retrieve information from, or the empty string
1576:    *        to return entities not associated with a catalog, or <code>null</code>
1577:    *        to return information from all catalogs.
1578:    * @param schema The schema to retrieve information from, or the empty string
1579:    *        to return entities not associated with a schema.
1580:    * @param tableName The table name to return information for.
1581:    * @param columnPattern A pattern of column names to return information for.
1582:    * @return A <code>ResultSet</code> with all the requested privileges.
1583:    * @exception SQLException If an error occurs.
1584:    */
1585:   ResultSet getColumnPrivileges(String catalog, String schema, String
1586:       tableName, String columnPattern) throws SQLException;
1587: 
1588:   /**
1589:    * This method returns the access rights that have been granted to the
1590:    * requested tables.  This information is returned as a <code>ResultSet</code>
1591:    * with the following columns:
1592:    *
1593:    * <ol>
1594:    * <li>TABLE_CAT - The catalog the table is in, which may be 
1595:    * <code>null</code>.</li>
1596:    * <li>TABLE_SCHEM - The schema the tables is in, which may be
1597:    * <code>null</code>.</li>
1598:    * <li>TABLE_NAME - The name of the table.</li>
1599:    * <li>GRANTOR - The entity that granted the access.</li>
1600:    * <li>GRANTEE - The entity granted the access.</li>
1601:    * <li>PRIVILEGE - The name of the privilege granted.</li>
1602:    * <li>IS_GRANTABLE - "YES" if the grantee can grant the privilege to
1603:    * others, "NO" if not, and <code>null</code> if unknown.</li>
1604:    * </ol>
1605:    *
1606:    * @param catalog The catalog to retrieve information from, or the empty string
1607:    *        to return entities not associated with a catalog, or <code>null</code>
1608:    *        to return information from all catalogs.
1609:    * @param schemaPattern The schema to retrieve information from, or the empty string
1610:    *        to return entities not associated with a schema.
1611:    * @param tablePattern The table name pattern of tables to return 
1612:    *        information for.
1613:    * @return A <code>ResultSet</code> with all the requested privileges.
1614:    * @exception SQLException If an error occurs.
1615:    */
1616:   ResultSet getTablePrivileges(String catalog, String schemaPattern,
1617:       String tablePattern) throws SQLException;
1618: 
1619:   /**
1620:    * This method returns the best set of columns for uniquely identifying
1621:    * a row.  It returns this information as a <code>ResultSet</code> with
1622:    * the following columns:
1623:    *
1624:    * <ol>
1625:    * <li>SCOPE - The scope of the results returned.  This is one of the 
1626:    * constants defined in this class (<code>bestRowTemporary</code>,
1627:    * <code>bestRowTransaction</code>, or <code>bestRowSession</code>).</li>
1628:    * <li>COLUMN_NAME - The name of the column.</li>
1629:    * <li>DATA_TYPE - The SQL type of the column. This is one of the constants
1630:    * defined in <code>Types</code>.</li>
1631:    * <li>TYPE_NAME - The string name of the data type for this column.</li>
1632:    * <li>COLUMN_SIZE - The precision of the columns</li>
1633:    * <li>BUFFER_LENGTH - Unused</li>
1634:    * <li>DECIMAL_DIGITS - The scale of the column.</li>
1635:    * <li>PSEUDO_COLUMN - Whether or not the best row identifier is a
1636:    * pseudo_column.  This is one of the constants defined in this class 
1637:    * (<code>bestRowUnknown</code>, <code>bestRowNotPseudo</code>, or
1638:    * <code>bestRowPseudo</code>).</li>
1639:    * </ol>
1640:    *
1641:    * @param catalog The catalog to retrieve information from, or the empty string
1642:    * to return entities not associated with a catalog, or <code>null</code>
1643:    * to return information from all catalogs.
1644:    * @param schema The schema to retrieve information from, or the empty string
1645:    * to return entities not associated with a schema.
1646:    * @param tableName The table name to return information for.
1647:    * @param scope One of the best row id scope constants from this class.
1648:    * @param nullable <code>true</code> to include columns that are nullable,
1649:    * <code>false</code> otherwise.
1650:    * @return A <code>ResultSet</code> with the best row identifier.
1651:    * @exception SQLException If an error occurs.
1652:    */
1653:   ResultSet getBestRowIdentifier(String catalog, String schema,
1654:     String tableName, int scope, boolean nullable) throws SQLException;
1655: 
1656:   /**
1657:    * This method returns the set of columns that are automatically updated
1658:    * when the row is update. It returns this information as a 
1659:    * <code>ResultSet</code> with the following columns:
1660:    *
1661:    * <ol>
1662:    * <li>SCOPE - Unused</li>
1663:    * <li>COLUMN_NAME - The name of the column.</li>
1664:    * <li>DATA_TYPE - The SQL type of the column. This is one of the constants
1665:    * defined in <code>Types</code>.</li>
1666:    * <li>TYPE_NAME - The string name of the data type for this column.</li>
1667:    * <li>COLUMN_SIZE - The precision of the columns</li>
1668:    * <li>BUFFER_LENGTH - Unused</li>
1669:    * <li>DECIMAL_DIGITS - The scale of the column.</li>
1670:    * <li>PSEUDO_COLUMN - Whether or not the best row identifier is a
1671:    * pseudo_column.  This is one of the constants defined in this class 
1672:    * (<code>versionRowUnknown</code>, <code>versionRowNotPseudo</code>, or
1673:    * <code>versionRowPseudo</code>).</li>
1674:    * </ol>
1675:    *
1676:    * @param catalog The catalog to retrieve information from, or the empty string
1677:    *        to return entities not associated with a catalog, or <code>null</code>
1678:    *        to return information from all catalogs.
1679:    * @param schema The schema to retrieve information from, or the empty string
1680:    *        to return entities not associated with a schema.
1681:    * @param tableName The table name to return information for
1682:    * @return A <code>ResultSet</code> with the version columns.
1683:    * @exception SQLException If an error occurs.
1684:    */
1685:   ResultSet getVersionColumns(String catalog, String schema,
1686:     String tableName) throws SQLException;
1687: 
1688:   /**
1689:    * This method returns a list of a table's primary key columns.  These
1690:    * are returned as a <code>ResultSet</code> with the following columns.
1691:    *
1692:    * <ol>
1693:    * <li>TABLE_CAT - The catalog of the table, which may be <code>null</code>.</li>
1694:    * <li>TABLE_SCHEM - The schema of the table, which may be <code>null</code>.</li>
1695:    * <li>TABLE_NAME - The name of the table.</li>
1696:    * <li>COLUMN_NAME - The name of the column.</li>
1697:    * <li>KEY_SEQ - The sequence number of the column within the primary key.</li>
1698:    * <li>PK_NAME - The name of the primary key, which may be <code>null</code>.</li>
1699:    * </ol>
1700:    *
1701:    * @param catalog The catalog to retrieve information from, or the empty string
1702:    *        to return entities not associated with a catalog, or <code>null</code>
1703:    *        to return information from all catalogs.
1704:    * @param schema The schema to retrieve information from, or the empty string
1705:    *        to return entities not associated with a schema.
1706:    * @param tableName The table name to return information for.
1707:    * @return A <code>ResultSet</code> with the primary key columns.
1708:    * @exception SQLException If an error occurs.
1709:    */
1710:   ResultSet getPrimaryKeys(String catalog, String schema, String tableName)
1711:       throws SQLException;
1712: 
1713:   /**
1714:    * This method returns a list of the table's foreign keys.  These are
1715:    * returned as a <code>ResultSet</code> with the following columns:
1716:    *
1717:    * <ol>
1718:    * <li>PKTABLE_CAT - The catalog of the table the key was imported from.</li>
1719:    * <li>PKTABLE_SCHEM - The schema of the table the key was imported from.</li>
1720:    * <li>PKTABLE_NAME - The name of the table the key was imported from.</li>
1721:    * <li>PKCOLUMN_NAME - The name of the column that was imported.</li>
1722:    * <li>FKTABLE_CAT - The foreign key catalog name.</li>
1723:    * <li>FKTABLE_SCHEM - The foreign key schema name.</li>
1724:    * <li>FKTABLE_NAME - The foreign key table name.</li>
1725:    * <li>FKCOLUMN_NAME - The foreign key column name.</li>
1726:    * <li>KEY_SEQ - The sequence number of the column within the foreign key.</li>
1727:    * <li>UPDATE_RULE - How the foreign key behaves when the primary key is
1728:    * updated.  This is one of the constants defined in this class 
1729:    * (<code>importedNoAction</code>, <code>importedKeyCascade</code>,
1730:    * <code>importedKeySetNull</code>, <code>importedKeySetDefault</code>, or
1731:    * <code>importedKeyRestrict</code>).</li>
1732:    * <li>DELETE_RULE - How the foreign key behaves when the primary key is
1733:    * deleted.  This is one of the constants defined in this class 
1734:    * (<code>importedNoAction</code>, <code>importedKeyCascade</code>,
1735:    * <code>importedKeySetNull</code>, or <code>importedKeySetDefault</code>)</li>
1736:    * <li>FK_NAME - The name of the foreign key.</li>
1737:    * <li>PK_NAME - The name of the primary key.</li>
1738:    * <li>DEFERRABILITY - The deferrability value.  This is one of the
1739:    * constants defined in this table (<code>importedKeyInitiallyDeferred</code>,
1740:    * <code>importedKeyInitiallyImmediate</code>, or
1741:    * <code>importedKeyNotDeferrable</code>).</li>
1742:    * </ol>
1743:    *
1744:    * @param catalog The catalog to retrieve information from, or the empty string
1745:    *        to return entities not associated with a catalog, or <code>null</code>
1746:    *        to return information from all catalogs.
1747:    * @param schema The schema to retrieve information from, or the empty string
1748:    *        to return entities not associated with a schema.
1749:    * @param tableName The table name to return information for.
1750:    * @return A <code>ResultSet</code> with the foreign key columns.
1751:    * @exception SQLException If an error occurs.
1752:    */
1753:   ResultSet getImportedKeys(String catalog, String schema,
1754:     String tableName) throws SQLException;
1755: 
1756:   /**
1757:    * This method returns a list of the table's which use this table's
1758:    * primary key as a foreign key.  The information is
1759:    * returned as a <code>ResultSet</code> with the following columns:
1760:    *
1761:    * <ol>
1762:    * <li>PKTABLE_CAT - The catalog of the table the key was imported from.</li>
1763:    * <li>PKTABLE_SCHEM - The schema of the table the key was imported from.</li>
1764:    * <li>PKTABLE_NAME - The name of the table the key was imported from.</li>
1765:    * <li>PKCOLUMN_NAME - The name of the column that was imported.</li>
1766:    * <li>FKTABLE_CAT - The foreign key catalog name.</li>
1767:    * <li>FKTABLE_SCHEM - The foreign key schema name.</li>
1768:    * <li>FKTABLE_NAME - The foreign key table name.</li>
1769:    * <li>FKCOLUMN_NAME - The foreign key column name.</li>
1770:    * <li>KEY_SEQ - The sequence number of the column within the foreign key.</li>
1771:    * <li>UPDATE_RULE - How the foreign key behaves when the primary key is
1772:    * updated.  This is one of the constants defined in this class 
1773:    * (<code>importedNoAction</code>, <code>importedKeyCascade</code>,
1774:    * <code>importedKeySetNull</code>, <code>importedKeySetDefault</code>, or
1775:    * <code>importedKeyRestrict</code>).</li>
1776:    * <li>DELETE_RULE - How the foreign key behaves when the primary key is
1777:    * deleted.  This is one of the constants defined in this class 
1778:    * (<code>importedNoAction</code>, <code>importedKeyCascade</code>,
1779:    * <code>importedKeySetNull</code>, or <code>importedKeySetDefault</code>)</li>
1780:    * <li>FK_NAME - The name of the foreign key.</li>
1781:    * <li>PK_NAME - The name of the primary key.</li>
1782:    * <li>DEFERRABILITY - The deferrability value.  This is one of the
1783:    * constants defined in this table (<code>importedKeyInitiallyDeferred</code>,
1784:    * <code>importedKeyInitiallyImmediate</code>, or
1785:    * <code>importedKeyNotDeferrable</code>).</li>
1786:    * </ol>
1787:    *
1788:    * @param catalog The catalog to retrieve information from, or the empty string
1789:    *        to return entities not associated with a catalog, or <code>null</code>
1790:    *        to return information from all catalogs.
1791:    * @param schema The schema to retrieve information from, or the empty string
1792:    *        to return entities not associated with a schema.
1793:    * @param tableName The table name to return information for.
1794:    * @return A <code>ResultSet</code> with the requested information
1795:    * @exception SQLException If an error occurs.
1796:    */
1797:   ResultSet getExportedKeys(String catalog, String schema,
1798:     String tableName) throws SQLException;
1799: 
1800:   /**
1801:    * This method returns a description of how one table imports another
1802:    * table's primary key as a foreign key.  The information is
1803:    * returned as a <code>ResultSet</code> with the following columns:
1804:    *
1805:    * <ol>
1806:    * <li>PKTABLE_CAT - The catalog of the table the key was imported from.</li>
1807:    * <li>PKTABLE_SCHEM - The schema of the table the key was imported from.</li>
1808:    * <li>PKTABLE_NAME - The name of the table the key was imported from.</li>
1809:    * <li>PKCOLUMN_NAME - The name of the column that was imported.</li>
1810:    * <li>FKTABLE_CAT - The foreign key catalog name.</li>
1811:    * <li>FKTABLE_SCHEM - The foreign key schema name.</li>
1812:    * <li>FKTABLE_NAME - The foreign key table name.</li>
1813:    * <li>FKCOLUMN_NAME - The foreign key column name.</li>
1814:    * <li>KEY_SEQ - The sequence number of the column within the foreign key.</li>
1815:    * <li>UPDATE_RULE - How the foreign key behaves when the primary key is
1816:    * updated.  This is one of the constants defined in this class 
1817:    * (<code>importedNoAction</code>, <code>importedKeyCascade</code>,
1818:    * <code>importedKeySetNull</code>, <code>importedKeySetDefault</code>, or
1819:    * <code>importedKeyRestrict</code>).</li>
1820:    * <li>DELETE_RULE - How the foreign key behaves when the primary key is
1821:    * deleted.  This is one of the constants defined in this class 
1822:    * (<code>importedNoAction</code>, <code>importedKeyCascade</code>,
1823:    * <code>importedKeySetNull</code>, or <code>importedKeySetDefault</code>)</li>
1824:    * <li>FK_NAME - The name of the foreign key.</li>
1825:    * <li>PK_NAME - The name of the primary key.</li>
1826:    * <li>DEFERRABILITY - The deferrability value.  This is one of the
1827:    * constants defined in this table (<code>importedKeyInitiallyDeferred</code>,
1828:    * <code>importedKeyInitiallyImmediate</code>, or
1829:    * <code>importedKeyNotDeferrable</code>).</li>
1830:    * </ol>
1831:    *
1832:    * @param primaryCatalog The catalog to retrieve information from, or the
1833:    *        empty string to return entities not associated with a catalog, or
1834:    *        <code>null</code> to return information from all catalogs, on the
1835:    *         exporting side.
1836:    * @param primarySchema The schema to retrieve information from, or the empty
1837:    *        string to return entities not associated with a schema, on the
1838:    *        exporting side.
1839:    * @param primaryTableName The table name to return information for, on the
1840:    *        exporting side.
1841:    * @param foreignCatalog The catalog to retrieve information from, or the
1842:    *        empty string to return entities not associated with a catalog,
1843:    *        or <code>null</code> to return information from all catalogs, on
1844:    *        the importing side.
1845:    * @param foreignSchema The schema to retrieve information from, or the
1846:    *        empty string to return entities not associated with a schema on
1847:    *        the importing side.
1848:    * @param foreignTableName The table name to return information for on the
1849:    *        importing side.
1850:    * @return A <code>ResultSet</code> with the requested information
1851:    * @exception SQLException If an error occurs.
1852:    */
1853:   ResultSet getCrossReference(String primaryCatalog, String
1854:     primarySchema, String primaryTableName, String foreignCatalog, String
1855:     foreignSchema, String foreignTableName) throws SQLException;
1856: 
1857:   /**
1858:    * This method returns a list of the SQL types supported by this
1859:    * database.  The information is returned as a <code>ResultSet</code>
1860:    * with the following columns:
1861:    *
1862:    * <ol>
1863:    * <li>TYPE_NAME - The name of the data type.</li>
1864:    * <li>DATA_TYPE - A data type constant from <code>Types</code> for this
1865:    * type.</li>
1866:    * <li>PRECISION - The maximum precision of this type.</li>
1867:    * <li>LITERAL_PREFIX - Prefix value used to quote a literal, which may be
1868:    * <code>null</code>.</li>
1869:    * <li>LITERAL_SUFFIX - Suffix value used to quote a literal, which may be
1870:    * <code>null</code>.</li>
1871:    * <li>CREATE_PARAMS - The parameters used to create the type, which may be
1872:    * <code>null</code>.</li>
1873:    * <li>NULLABLE - Whether or not this type supports NULL values.  This will
1874:    * be one of the constants defined in this interface 
1875:    * (<code>typeNoNulls</code>, <code>typeNullable</code>, or
1876:    * <code>typeNullableUnknown</code>).</li>
1877:    * <li>CASE_SENSITIVE - Whether or not the value is case sensitive.</li>
1878:    * <li>SEARCHABLE - Whether or not "LIKE" expressions are supported in
1879:    * WHERE clauses for this type.  This will be one of the constants defined
1880:    * in this interface (<code>typePredNone</code>, <code>typePredChar</code>,
1881:    * <code>typePredBasic</code>, or <code>typeSearchable</code>).</li>
1882:    * <li>UNSIGNED_ATTRIBUTE - Is the value of this type unsigned.</li>
1883:    * <li>FIXED_PREC_SCALE - Whether or not this type can be used for money.</li>
1884:    * <li>AUTO_INCREMENT - Whether or not this type supports auto-incrementing.</li>
1885:    * <li>LOCAL_TYPE_NAME - A localized name for this data type.</li>
1886:    * <li>MINIMUM_SCALE - The minimum scale supported by this type.</li>
1887:    * <li>MAXIMUM_SCALE - The maximum scale supported by this type.</li>
1888:    * <li>SQL_DATA_TYPE - Unused.</li>
1889:    * <li>SQL_DATETIME_SUB - Unused.</li>
1890:    * <li>NUM_PREC_RADIX - The radix of this data type.</li>
1891:    * </ol>
1892:    * 
1893:    * @return A <code>ResultSet</code> with the list of available data types.
1894:    * @exception SQLException If an error occurs.
1895:    */
1896:   ResultSet getTypeInfo() throws SQLException;
1897: 
1898:   /**
1899:    * This method returns information about a tables indices and statistics.
1900:    * It is returned as a <code>ResultSet</code> with the following columns:
1901:    *
1902:    * <ol>
1903:    * <li>TABLE_CAT - The catalog of the table, which may be <code>null</code>.</li>
1904:    * <li>TABLE_SCHEM - The schema of the table, which may be <code>null</code>.</li>
1905:    * <li>TABLE_NAME - The name of the table.</li>
1906:    * <li>NON_UNIQUE - Are index values non-unique?</li>
1907:    * <li>INDEX_QUALIFIER The index catalog, which may be <code>null</code></li>
1908:    * <li>INDEX_NAME - The name of the index.</li>
1909:    * <li>TYPE - The type of index, which will be one of the constants defined
1910:    * in this interface (<code>tableIndexStatistic</code>,
1911:    * <code>tableIndexClustered</code>, <code>tableIndexHashed</code>, or
1912:    * <code>tableIndexOther</code>).</li>
1913:    * <li>ORDINAL_POSITION - The sequence number of this column in the index.
1914:    * This will be 0 when the index type is <code>tableIndexStatistic</code>.</li>
1915:    * <li>COLUMN_NAME - The name of this column in the index.</li>
1916:    * <li>ASC_OR_DESC - "A" for an ascending sort sequence, "D" for a
1917:    * descending sort sequence or <code>null</code> if a sort sequence is not
1918:    * supported.</li>
1919:    * <li>CARDINALITY - The number of unique rows in the index, or the number
1920:    * of rows in the table if the index type is <code>tableIndexStatistic</code>.</li>
1921:    * <li>PAGES - The number of pages used for the index, or the number of pages
1922:    * in the table if the index type is <code>tableIndexStatistic</code>.</li>
1923:    * <li>FILTER_CONDITION - The filter condition for this index, which may be
1924:    * <code>null</code>.</li>
1925:    * </ol>
1926:    *
1927:    * @param catalog The catalog to retrieve information from, or the empty string
1928:    *        to return entities not associated with a catalog, or 
1929:    *        <code>null</code> to return information from all catalogs.
1930:    * @param schema The schema to retrieve information from, or the empty string
1931:    *        to return entities not associated with a schema.
1932:    * @param tableName The table name to return information for.
1933:    * @param unique <code>true</code> to return only unique indexes, 
1934:    *        <code>false</code> otherwise.
1935:    * @param approximate <code>true</code> if data values can be approximations,
1936:    *        <code>false</code> otherwise.
1937:    * @return A <code>ResultSet</code> with the requested index information
1938:    * @exception SQLException If an error occurs.
1939:    */
1940:   ResultSet getIndexInfo(String catalog, String schema, String tableName,
1941:     boolean unique, boolean approximate) throws SQLException;
1942: 
1943:   /**
1944:    * This method tests whether or not the datbase supports the specified
1945:    * result type.
1946:    *
1947:    * @param type The desired result type, which is one of the constants
1948:    * defined in <code>ResultSet</code>.
1949:    *
1950:    * @return <code>true</code> if the result set type is supported,
1951:    * <code>false</code> otherwise.
1952:    *
1953:    * @exception SQLException If an error occurs.
1954:    *
1955:    * @see ResultSet
1956:    */
1957:   boolean supportsResultSetType(int type) throws SQLException;
1958: 
1959:   /**
1960:    * This method tests whether the specified result set type and result set
1961:    * concurrency type are supported by the database.
1962:    *
1963:    * @param type The desired result type, which is one of the constants
1964:    *        defined in <code>ResultSet</code>.
1965:    * @param concurrency The desired concurrency type, which is one of the
1966:    *                    constants defined in <code>ResultSet</code>.
1967:    * @return <code>true</code> if the result set type is supported,
1968:    *         <code>false</code> otherwise.
1969:    * @exception SQLException If an error occurs.
1970:    * @see ResultSet
1971:    */
1972:   boolean supportsResultSetConcurrency(int type, int concurrency)
1973:       throws SQLException;
1974: 
1975:   /**
1976:    * This method tests whether or not the specified result set type sees its
1977:    * own updates.
1978:    *
1979:    * @param type The desired result type, which is one of the constants
1980:    *        defined in <code>ResultSet</code>.
1981:    * @return <code>true</code> if the result set type sees its own updates,
1982:    *         <code>false</code> otherwise.
1983:    * @exception SQLException If an error occurs.
1984:    * @see ResultSet
1985:    */
1986:   boolean ownUpdatesAreVisible(int type) throws SQLException;
1987: 
1988:  /**
1989:    * This method tests whether or not the specified result set type sees its
1990:    * own deletes.
1991:    *
1992:    * @param type The desired result type, which is one of the constants
1993:    *        defined in <code>ResultSet</code>.
1994:    * @return <code>true</code> if the result set type sees its own deletes,
1995:    *         <code>false</code> otherwise.
1996:    * @exception SQLException If an error occurs.
1997:    * @see ResultSet
1998:    */
1999:   boolean ownDeletesAreVisible(int type) throws SQLException;
2000: 
2001:   /**
2002:    * This method tests whether or not the specified result set type sees its
2003:    * own inserts.
2004:    *
2005:    * @param type The desired result type, which is one of the constants
2006:    *        defined in <code>ResultSet</code>.
2007:    * @return <code>true</code> if the result set type sees its own inserts,
2008:    *         <code>false</code> otherwise.
2009:    * @exception SQLException If an error occurs.
2010:    * @see ResultSet
2011:    */
2012:   boolean ownInsertsAreVisible(int type) throws SQLException;
2013: 
2014:   /**
2015:    * This method tests whether or not the specified result set type sees 
2016:    * updates committed by others.
2017:    *
2018:    * @param type The desired result type, which is one of the constants
2019:    *        defined in <code>ResultSet</code>.
2020:    * @return <code>true</code> if the result set type sees other updates,
2021:    *         <code>false</code> otherwise.
2022:    * @exception SQLException If an error occurs.
2023:    * @see ResultSet
2024:    */
2025:   boolean othersUpdatesAreVisible(int type) throws SQLException;
2026: 
2027:   /**
2028:    * This method tests whether or not the specified result set type sees 
2029:    * deletes committed by others.
2030:    *
2031:    * @param type The desired result type, which is one of the constants
2032:    *        defined in <code>ResultSet</code>.
2033:    * @return <code>true</code> if the result set type sees other deletes,
2034:    *         <code>false</code> otherwise.
2035:    * @exception SQLException If an error occurs.
2036:    * @see ResultSet
2037:    */
2038:   boolean othersDeletesAreVisible(int type) throws SQLException;
2039: 
2040:   /**
2041:    * This method tests whether or not the specified result set type sees 
2042:    * inserts committed by others.
2043:    *
2044:    * @param type The desired result type, which is one of the constants
2045:    *        defined in <code>ResultSet</code>.
2046:    * @return <code>true</code> if the result set type sees other inserts,
2047:    *         <code>false</code> otherwise.
2048:    * @exception SQLException If an error occurs.
2049:    * @see ResultSet
2050:    */
2051:   boolean othersInsertsAreVisible(int type) throws SQLException;
2052: 
2053:   /**
2054:    * This method tests whether or not the specified result set type can detect
2055:    * a visible update by calling the <code>rowUpdated</code> method.
2056:    *
2057:    * @param type The desired result type, which is one of the constants
2058:    *        defined in <code>ResultSet</code>.
2059:    * @return <code>true</code> if the result set type can detect visible updates
2060:    *         using <code>rowUpdated</code>, <code>false</code> otherwise.
2061:    * @exception SQLException If an error occurs.
2062:    * @see ResultSet
2063:    */
2064:   boolean updatesAreDetected(int type) throws SQLException;
2065: 
2066:   /**
2067:    * This method tests whether or not the specified result set type can detect
2068:    * a visible delete by calling the <code>rowUpdated</code> method.
2069:    *
2070:    * @param type The desired result type, which is one of the constants
2071:    *        defined in <code>ResultSet</code>.
2072:    * @return <code>true</code> if the result set type can detect visible deletes
2073:    *         using <code>rowUpdated</code>, <code>false</code> otherwise.
2074:    * @exception SQLException If an error occurs.
2075:    * @see ResultSet
2076:    */
2077:   boolean deletesAreDetected(int type) throws SQLException;
2078:   
2079:   /**
2080:    * This method tests whether or not the specified result set type can detect
2081:    * a visible insert by calling the <code>rowUpdated</code> method.
2082:    *
2083:    * @param type The desired result type, which is one of the constants
2084:    *        defined in <code>ResultSet</code>.
2085:    * @return <code>true</code> if the result set type can detect visible inserts
2086:    *         using <code>rowUpdated</code>, <code>false</code> otherwise.
2087:    * @exception SQLException If an error occurs.
2088:    * @see ResultSet
2089:    */
2090:   boolean insertsAreDetected(int type) throws SQLException;
2091: 
2092:   /**
2093:    * This method tests whether or not the database supports batch updates.
2094:    *
2095:    * @return <code>true</code> if batch updates are supported,
2096:    *         <code>false</code> otherwise.
2097:    * @exception SQLException If an error occurs.
2098:    */
2099:   boolean supportsBatchUpdates() throws SQLException;
2100: 
2101:   /**
2102:    * This method returns the list of user defined data types in use.  These
2103:    * are returned as a <code>ResultSet</code> with the following columns:
2104:    *
2105:    * <ol>
2106:    * <li>TYPE_CAT - The catalog name, which may be <code>null</code>.</li>
2107:    * <li>TYPE_SCEHM - The schema name, which may be <code>null</code>.</li>
2108:    * <li>TYPE_NAME - The user defined data type name.</li>
2109:    * <li>CLASS_NAME - The Java class name this type maps to.</li>
2110:    * <li>DATA_TYPE - A type identifier from <code>Types</code> for this type.
2111:    * This will be one of <code>JAVA_OBJECT</code>, <code>STRUCT</code>, or
2112:    * <code>DISTINCT</code>.</li>
2113:    * <li>REMARKS - Comments about this data type.</li>
2114:    * </ol>
2115:    *
2116:    * @param catalog The catalog to retrieve information from, or the empty string
2117:    *        to return entities not associated with a catalog, or <code>null</code>
2118:    *        to return information from all catalogs.
2119:    * @param schemaPattern The schema to retrieve information from, or the
2120:    *        empty string to return entities not associated with a schema.
2121:    * @param typePattern The type name pattern to match.
2122:    * @param types The type identifier patterns (from <code>Types</code>) to
2123:    *        match.
2124:    * @return A <code>ResultSet</code> with the requested type information
2125:    * @exception SQLException If an error occurs.
2126:    */
2127:   ResultSet getUDTs(String catalog, String schemaPattern, String
2128:       typePattern, int[] types) throws SQLException;
2129: 
2130:   /**
2131:    * This method returns the <code>Connection</code> object that was used
2132:    * to generate the metadata in this object.
2133:    *
2134:    * @return The connection for this object.
2135:    * @exception SQLException If an error occurs.
2136:    */
2137:   Connection getConnection() throws SQLException;
2138: 
2139:   /**
2140:    * This method tests whether the databse supports savepoints.
2141:    * 
2142:    * @return <code>true</code> if the database supports savepoints,
2143:    *         <code>false</code> if it does not.
2144:    * @exception SQLException If an error occurs.
2145:    * @see Savepoint
2146:    * @since 1.4
2147:    */
2148:   boolean supportsSavepoints() throws SQLException;
2149: 
2150:   /**
2151:    * This method tests whether the database supports named parameters.
2152:    * 
2153:    * @return <code>true</code> if the database supports named parameters,
2154:    *         <code>false</code> if it does not.
2155:    * @exception SQLException If an error occurs.
2156:    * @since 1.4
2157:    */
2158:   boolean supportsNamedParameters() throws SQLException;
2159: 
2160:   /**
2161:    * This method tests whether the database supports returning multiple
2162:    * <code>ResultSet</code>S from a <code>CallableStatement</code> at once.
2163:    * 
2164:    * @return <code>true</code> if the database supports returnig multiple
2165:    *         results at once, <code>false</code> if it does not.
2166:    * @exception SQLException If an error occurs.
2167:    * @since 1.4
2168:    */
2169:   boolean supportsMultipleOpenResults() throws SQLException;
2170: 
2171:   /**
2172:    * @since 1.4
2173:    */
2174:   boolean supportsGetGeneratedKeys() throws SQLException;
2175: 
2176:   /**
2177:    * @since 1.4
2178:    */
2179:   ResultSet getSuperTypes(String catalog, String schemaPattern,
2180:     String typePattern) throws SQLException;
2181: 
2182:   /**
2183:    * @since 1.4
2184:    */
2185:   ResultSet getSuperTables(String catalog, String schemaPattern,
2186:     String tablePattern) throws SQLException;
2187: 
2188:   /**
2189:    * @since 1.4
2190:    */
2191:   ResultSet getAttributes(String catalog, String schemaPattern, String
2192:     typePattern, String attributePattern) throws SQLException;
2193: 
2194:   /**
2195:    * This method tests if the database supports the specified holdability type.
2196:    * Valid values for this parameter are specified in the
2197:    * <code>ResultSet</code> class.
2198:    * 
2199:    * @param holdability The holdability type to test.
2200:    * @return <code>true</code> if the database supports the holdability type,
2201:    *         <code>false</code> if it does not.
2202:    * @exception SQLException If an error occurs.
2203:    * @see ResultSet
2204:    * @since 1.4
2205:    */
2206:   boolean supportsResultSetHoldability(int holdability)
2207:     throws SQLException;
2208: 
2209:   /**
2210:    * This method returns the default holdability type of <code>ResultSet</code>S
2211:    * retrieved from this database. The possible values are specified in the
2212:    * <code>ResultSet</code> class.
2213:    * 
2214:    * @return The default holdability type.
2215:    * @exception SQLException If an error occurs.
2216:    * @since 1.4
2217:    */
2218:   int getResultSetHoldability() throws SQLException;
2219: 
2220:   /**
2221:    * This method returns the major version number of the database.
2222:    * 
2223:    * @return The major version number of the database.
2224:    * @exception SQLException If an error occurs.
2225:    * @since 1.4
2226:    */
2227:   int getDatabaseMajorVersion() throws SQLException;
2228: 
2229:   /**
2230:    * This method returns the minor version number of the database.
2231:    * 
2232:    * @return The minor version number of the database.
2233:    * @exception SQLException If an error occurs.
2234:    * @since 1.4
2235:    */
2236:   int getDatabaseMinorVersion() throws SQLException;
2237: 
2238:   /**
2239:    * This method returns the major version number of the JDBC driver.
2240:    * 
2241:    * @return The major version number of the JDBC driver.
2242:    * @exception  SQLException If an error occurs.
2243:    * @since 1.4
2244:    */
2245:   int getJDBCMajorVersion() throws SQLException;
2246: 
2247:   /**
2248:    * This method returns the minor version number of the JDBC driver.
2249:    * 
2250:    * @return The minor version number of the database.
2251:    * @exception SQLException If an error occurs.
2252:    * @since 1.4
2253:    */
2254:   int getJDBCMinorVersion() throws SQLException;
2255: 
2256:   /**
2257:    * @since 1.4
2258:    */
2259:   int getSQLStateType() throws SQLException;
2260: 
2261:   /**
2262:    * @since 1.4
2263:    */
2264:   boolean locatorsUpdateCopy() throws SQLException;
2265: 
2266:   /**
2267:    * @since 1.4
2268:    */
2269:   boolean supportsStatementPooling() throws SQLException;
2270: }
