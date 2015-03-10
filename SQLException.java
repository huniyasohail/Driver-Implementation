 /* SQLException.java -- General SQL exception
   2:    Copyright (C) 1999, 2000 Free Software Foundation, Inc.
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
   
   /**
  42:  * This exception is thrown when a database error occurs.
  43:  *
  44:  * @author Aaron M. Renn (arenn@urbanophile.com)
  45:  */
   public class SQLException extends Exception 
   {
     static final long serialVersionUID = 2135244094396331484L;
   
     /**
  51:    * This is the next exception in the chain
  52:    */
     private SQLException next;
   
     /**
  56:    * This is the state of the SQL statement at the time of the error.
  57:    */
     private String SQLState;
   
     /**
  61:    * The vendor error code for this error
  62:    */
     private int vendorCode;
  
    /**
  66:    * This method initializes a nwe instance of <code>SQLException</code>
  67:    * with the specified descriptive error message, SQL state string, and
  68:    * vendor code.
  69:    *
  70:    * @param message A string describing the nature of the error.
  71:    * @param SQLState A string containing the SQL state of the error.
  72:    * @param vendorCode The vendor error code associated with this error.
  73:    */
     public SQLException(String message, String SQLState, int vendorCode)
     {
       super(message);
       this.SQLState = SQLState;
       this.vendorCode = vendorCode;  
     }
   
     /**
  82:    * This method initializes a new instance of <code>SQLException</code>
  83:    * with the specified descriptive error message and SQL state string.
  84:    * The vendor error code of this instance will be 0.
  85:    *
  86:    * @param message A string describing the nature of the error.
  87:    * @param SQLState A string containing the SQL state of the error.
  88:    */
     public SQLException(String message, String SQLState)
     {
       this(message, SQLState, 0);
     }
   
     /**
  95:    * This method initializes a new instance of <code>SQLException</code>
  96:    * with the specified descriptive error message.  The SQL state of this
  97:    * instance will be <code>null</code> and the vendor error code will be 0.
  98:    *
  99:    * @param message A string describing the nature of the error.
 100:    */
    public SQLException(String message)
    {
      this(message, null, 0);  
    }
  
    /**
 107:    * This method initializes a new instance of <code>SQLException</code>
 108:    * that does not have a descriptive messages and SQL state, and which
 109:    * has a vendor error code of 0.
 110:    */
    public SQLException()
   {
      this(null, null, 0);  
    }
  
    /**
 117:    * This method returns the SQLState information associated with this
 118:    * error.  The value returned is a <code>String</code> which is formatted
 119:    * using the XOPEN SQL state conventions.
 120:    *
 121:    * @return The SQL state, which may be <code>null</code>.
 122:    */
    public String getSQLState()
    {
      return SQLState;
    }
  
    /**
 129:    * This method returns the vendor specific error code associated with 
 130:    * this error.
 131:    *
 132:    * @return The vendor specific error code associated with this error.
 133:    */
    public int getErrorCode()
    {
      return vendorCode;
    }
  
    /**
 140:    * This method returns the exception that is chained to this object.
 141:    *
 142:    * @return The exception chained to this object, which may be 
 143:    *         <code>null</code>.
 144:    */
    public SQLException getNextException()
    {
      return next;
    }
  
   /**
 151:    * This method adds a new exception to the end of the chain of exceptions
 152:    * that are chained to this object.
 153:    *
 154:    * @param e The exception to add to the end of the chain.
 155:    */
    public void setNextException(SQLException e)
    {
      if (e == null)
        return;
  
      SQLException list_entry = this;
      while (list_entry.getNextException() != null)
        list_entry = list_entry.getNextException();
  
      list_entry.next = e;
    }
  }
