/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package java.sql.start;
/* DriverManager.java -- Manage JDBC drivers
2:    Copyright (C) 1999, 2000, 2001, 2003, 2004, 2006
3:    Free Software Foundation, Inc.
4: 
5: This file is part of GNU Classpath.
6: 
7: GNU Classpath is free software; you can redistribute it and/or modify
8: it under the terms of the GNU General Public License as published by
9: the Free Software Foundation; either version 2, or (at your option)
10: any later version.
11:  
12: GNU Classpath is distributed in the hope that it will be useful, but
13: WITHOUT ANY WARRANTY; without even the implied warranty of
14: MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
15: General Public License for more details.
16: 
17: You should have received a copy of the GNU General Public License
18: along with GNU Classpath; see the file COPYING.  If not, write to the
19: Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
20: 02110-1301 USA.
21: 
22: Linking this library statically or dynamically with other modules is
23: making a combined work based on this library.  Thus, the terms and
24: conditions of the GNU General Public License cover the whole
25: combination.
26: 
27: As a special exception, the copyright holders of this library give you
28: permission to link this library with independent modules to produce an
29: executable, regardless of the license terms of these independent
30: modules, and to copy and distribute the resulting executable under
31: terms of your choice, provided that you also meet, for each linked
32: independent module, the terms and conditions of the license of that
33: module.  An independent module is a module which is not derived from
34: or based on this library.  If you modify this library, you may extend
35: this exception to your version of the library, but you are not
36: obligated to do so.  If you do not wish to do so, delete this
37: exception statement from your version. */
 
 
 
 import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.start.Driver;
 
 
 /**
49:   * This class manages the JDBC drivers in the system. It maintains a
50:   * registry of drivers and locates the appropriate driver to handle a
51:   * JDBC database URL.
52:   * <p>
53:   * On startup, <code>DriverManager</code> loads all the managers specified
54:   * by the system property <code>jdbc.drivers</code>.  The value of this
55:   * property should be a colon separated list of fully qualified driver
56:   * class names.  Additional drivers can be loaded at any time by
57:   * simply loading the driver class with <code>class.forName(String)</code>.
58:   * The driver should automatically register itself in a static 
59:   * initializer.
60:   * <p>
61:   * The methods in this class are all <code>static</code>. This class
62:   * cannot be instantiated.
63:   *
64:   * @author Aaron M. Renn (arenn@urbanophile.com)
65:   */
 public class DriverManger 
 {
   /**
69:    * This is the log stream for JDBC drivers.
70:    */
   private static PrintStream log_stream;
 
   /**
74:    * This is the log writer for JDBC drivers.
75:    */
   private static PrintWriter log_writer;
 
   /**
79:    * This is the login timeout used by JDBC drivers.
80:    */
   private static int login_timeout;
 
  /**
84:    * This is the list of JDBC drivers that are loaded.
:    */
   private static Vector drivers;
    // Hmm, seems like we might want to do a Hashtable and lookup by something,
    // but what would it be?
 
   // Load all drivers on startup
   static
   {
     drivers = new Vector();
 
     String driver_string = System.getProperty("jdbc.drivers");
     if (driver_string != null)
       {
     StringTokenizer st = new StringTokenizer(driver_string);
     while (st.hasMoreTokens())
           {
             String driver_classname = st.nextToken();
 
             try
               {
             Class.forName(driver_classname); // The driver registers itself
               }
             catch (Exception e)
           {
         // Ignore not founds
           }
           }
       }
 
   }
 
   /** Can't be instantiated. */
   private DriverManger()
   {
   }
 
   /**
122:    * This method returns the log writer being used by all JDBC drivers.
123:    * This method should be used in place of the deprecated
124:    * <code>getLogStream</code> method.
125:    *
126:    * @return The log writer in use by JDBC drivers.
127:    */
   public static PrintWriter getLogWriter()
   {
     return log_writer;
}
/**
134:    * This method sets the log writer being used by JDBC drivers.  This is a
135:    * system-wide parameter that affects all drivers.  Note that since there
136:    * is no way to retrieve a <code>PrintStream</code> from a 
137:    * <code>PrintWriter</code>, this method cannot set the log stream in
138:    * use by JDBC.  Thus any older drivers may not see this setting.
139:    *
140:    * @param out The new log writer for JDBC.
41:    */
   public static void setLogWriter(PrintWriter out)
  {
     DriverManger.log_writer = out;
   }
 
 /**
148:   * This method attempts to return a connection to the specified
149:   * JDBC URL string using the specified connection properties.
150:   *
151:   * @param url The JDBC URL string to connect to.
152:   * @param properties The connection properties.
153:   *
154:   * @return A <code>Connection</code> to that URL.
155:   *
156:   * @exception SQLException If an error occurs.
7:   */
   public static Connection getConnection(String url, Properties properties)
     throws SQLException
   {
     Driver d = getDriver(url);
     if (d == null)
       throw new SQLException("Driver not found for URL: " + url);
 
     return d.connect(url, properties);
   }
 
 
   /**
170:    * This method attempts to return a connection to the specified
171:    * JDBC URL string using the specified username and password.
172:    *
173:    * @param url The JDBC URL string to connect to.
174:    * @param user The username to connect with.
175:    * @param password The password to connect with.
176:    * @return A <code>Connection</code> to that URL.
177:    * @exception SQLException If an error occurs.
8:    */
   public static Connection getConnection(String url, String user,
     String password) throws SQLException
   {
     Properties p = new Properties();
 
     if (user != null)
       p.setProperty("user", user);
     if (password != null)
       p.setProperty("password", password);
 
     return getConnection(url, p);
   }
 
   /**
193:    * This method attempts to return a connection to the specified
194:    * JDBC URL string.
195:    *
196:    * @param url The JDBC URL string to connect to.
197:    *
198:    * @return A <code>Connection</code> to that URL.
199:    *
200:    * @exception SQLException If an error occurs.
201:    */
   public static Connection getConnection(String url) throws SQLException
   {
     return getConnection(url, new Properties());
   }
 
   /**
208:    * This method returns a driver that can connect to the specified
209:    * JDBC URL string.  This will be selected from among drivers loaded
210:    * at initialization time and those drivers manually loaded by the
211:    * same class loader as the caller.
212:    *
213:    * @param url The JDBC URL string to find a driver for.
214:    *
215:    * @return A <code>Driver</code> that can connect to the specified
216:    * URL.
7:    *
:    * @exception SQLException If an error occurs, or no suitable driver can be found.
    */
   public static Driver getDriver(String url) throws SQLException
  {
     // FIXME: Limit driver search to the appropriate subset of loaded drivers.
     Enumeration e = drivers.elements();
     while(e.hasMoreElements())
       {
     Driver d = (Driver)e.nextElement();
     if (d.acceptsURL(url))
           return d;
       }
     throw new SQLException("No driver found for " + url);
   }
   /**
235:    * This method registers a new driver with the manager.  This is normally
236:    * called by the driver itself in a static initializer.
237:    *
238:    * @param driver The new <code>Driver</code> to add.
239:    *
240:    * @exception SQLException If an error occurs.
241:    */
   public static void registerDriver(Driver driver) throws SQLException
   {
     if (! drivers.contains(driver))
       drivers.addElement(driver);  
   }
 
 /**
   * This method de-registers a driver from the manager.
   *
  * @param driver The <code>Driver</code> to unregister.
   *
   * @exception SQLException If an error occurs.
   */
   public static void deregisterDriver(Driver driver) throws SQLException
   {
     if (drivers.contains(driver))
       drivers.removeElement(driver);
   }
 
   /**
    * This method returns a list of all the currently registered JDBC drivers
    * that were loaded by the current <code>ClassLoader</code>.
    *
    * @return An <code>Enumeration</code> of all currently loaded JDBC drivers.
    */
   public static Enumeration getDrivers()
   {
     Vector v = new Vector();
     Enumeration e = drivers.elements();
 
     // Is this right?
     ClassLoader cl = Thread.currentThread().getContextClassLoader();
 
     while(e.hasMoreElements())
       {
     Object obj = e.nextElement();

     ClassLoader loader = obj.getClass().getClassLoader();
 
     if (loader == null)
      loader = ClassLoader.getSystemClassLoader();
     if (! loader.equals(cl))
       continue;
 
     v.addElement(obj);
       } 
 
     return v.elements();
   }
 
   /**
    * This method set the login timeout used by JDBC drivers.  This is a
    * system-wide parameter that applies to all drivers.
    *
    * @param seconds The new login timeout value.
    */
   public static void setLoginTimeout(int seconds)
   {
     DriverManger.login_timeout = seconds;  
   }
 
   /**
   * This method returns the login timeout in use by JDBC drivers systemwide.
    *
    * @return The login timeout.
    */
   public static int getLoginTimeout()
   {
     return login_timeout;
   }
 
   /**
    * This method sets the log stream in use by JDBC.
    *
    * @param stream The log stream in use by JDBC.
    * @deprecated Use <code>setLogWriter</code> instead.
    */
   public static void setLogStream(PrintStream stream)
   {
     DriverManger.log_stream = stream;
   }
 
   /**
    * This method returns the log stream in use by JDBC.
    *
    * @return The log stream in use by JDBC.
    * @deprecated Use <code>getLogWriter()</code> instead.
   */
   public static PrintStream getLogStream()
   {
     return log_stream;
   }
 
   /**
    * This method prints the specified line to the log stream.
    *
   * @param message The string to write to the log stream.
    */
   public static void println(String message)
   {
     if (log_stream != null) // Watch for user not using logging
       log_stream.println(message);
   }
 }
