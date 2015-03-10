  /* Copyright (C) 1999, 2000, 2006 Free Software Foundation, Inc.
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
   obligated to do so.  If you do not wish to do so, delete this
  36: exception statement from your version. */
   
   package java.sql.start;
   
   import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
   
   /**
  43:   * This interface specifies a mechanism for accessing a JDBC database
  44:   * driver.  When the class implementing this method is loaded, it should
  45:   * register an instance of itself with the <code>DriverManager</code> in
  46:   * a static initializer.  
  47:   * <p>
  48:   * Because the <code>DriverManager</code> might attempt to use several
  49:   * drivers to find one that can connect to the requested database, 
  50:   * this driver should not cause large numbers of classes and code to
  51:   * be loaded.  If another driver is the one that ends up performing the
  52:   * request, any loading done by this driver would be wasted.
  53:   *
  54:   * @author Aaron M. Renn (arenn@urbanophile.com)
  55:   */
   public interface Driver 
   {
     /**
  59:    * This method connects to the specified database using the connection
  60:    * properties supplied.  If the driver does not understand the database
  61:    * URL, it should return <code>null</code> instead of throwing an
  62:    * exception since the <code>DriverManager</code> will probe a driver
  63:    * in this manner.
  64:    * 
  65:    * @param url The URL string for this connection.
  66:    * @param properties The list of database connection properties.
  67:    * @return A <code>Connection</code> object for the newly established
  68:    *         connection, or <code>null</code> if the URL is not understood.
  69:    * @exception SQLException If an error occurs.
  :    */
     Connection connect(String url, Properties properties) throws SQLException;
   
     /**
  74:    * This method tests whether or not the driver believes it can connect to
  75:    * the specified database.  The driver should only test whether it 
  76:    * understands and accepts the URL. It should not necessarily attempt to 
  77:    * probe the database for a connection.
  78:    *
  79:    * @param url The database URL string.
  80:    * @return <code>true</code> if the drivers can connect to the database, 
  81:    *         <code>false</code> otherwise.
  82:    * @exception SQLException If an error occurs.
  83:    */
     boolean acceptsURL(String url) throws SQLException;
   
     /**
  87:    * This method returns an array of possible properties that could be
  88:    * used to connect to the specified database.
  89:    *
  90:    * @param url The URL string of the database to connect to.
  91:    * @param properties The list of properties the caller is planning to use
  92:    *        to connect to the database.
  93:    * @return A list of possible additional properties for a connection to this
  94:    *         database.  This list may be empty.
  95:    * @exception SQLException If an error occurs.
  96:    */
     DriverPropertyInfo[] getPropertyInfo(String url, Properties properties)
       throws SQLException;
   
    /**
 101:    * This method returns the major version number of the driver.
 102:    *
 103:    * @return The major version number of the driver.
 4:    */      
    int getMajorVersion();
  
    /**
 108:    * This method returns the minor version number of the driver.
 109:    *
 110:    * @return The minor version number of the driver.
 111:    */
    int getMinorVersion();
  
    /**
 115:    * This method tests whether or not the driver is JDBC compliant.  This
 116:    * method should only return <code>true</code> if the driver has been
 117:    * certified as JDBC compliant.
 118:    *
 119:    * @return <code>true</code> if the driver has been certified JDBC compliant,
 120:    *         <code>false</code> otherwise.
 121:    */
    boolean jdbcCompliant();
  }