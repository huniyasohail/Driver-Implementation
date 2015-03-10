 
   package java.sql.start;
   
   import java.io.InputStream;
   import java.io.OutputStream;
   import java.io.Reader;
  import java.io.Writer;
  
   /**
  47:  * This interface contains methods for accessing a SQL CLOB (Character Large
  48:  * OBject) type.
  49:  * 
  50:  * @author Aaron M. Renn (arenn@urbanophile.com)
  51:  */
   public interface Clob
   {
     /**
  55:    * This method returns the number of characters in this <code>Clob</code>.
  56:    * 
  57:    * @return The number of characters in this <code>Clob</code>.
  58:    * @exception SQLException If an error occurs.
  59:    * @since 1.2
  60:    */
     long length() throws SQLException;
   
     /**
  64:    * This method returns the specified portion of this <code>Clob</code> as a
  65:    * <code>String</code>.
  66:    * 
  67:    * @param start The index into this <code>Clob</code> (index values
  68:    *              start at 1) to start returning characters from.
  69:    * @param count The requested number of characters to return.
  70:    * @return The requested <code>Clob</code> section, as a <code>String</code>.
  71:    * @exception SQLException If an error occurs.
  72:    * @since 1.2
  73:    */
     String getSubString(long start, int count) throws SQLException;
   
     /**
  7:    * This method returns a character stream that reads the contents of this
  78:    * <code>Clob</code>.
  79:    * 
  80:    * @return A character stream to read this <code>Clob</code>'s contents.
  81:    * @exception SQLException If an error occurs.
  82:    * @since 1.2
  83:    */
     Reader getCharacterStream() throws SQLException;
   
     /**
  87:    * This method returns a byte stream that reads the contents of this
  88:    * <code>Clob</code> as a series of ASCII bytes.
  89:    * 
  90:    * @return A stream to read this <code>Clob</code>'s contents.
  91:    * @exception SQLException If an error occurs.
  92:    * @since 1.2
  93:    */
     InputStream getAsciiStream() throws SQLException;
   
     /**
  97:    * This method returns the index into this <code>Clob</code> of the first
  98:    * occurrence of the specified character pattern (supplied by the caller as a
  99:    * <code>String</code>). The search begins at the specified index.
 100:    * 
 101:    * @param pattern The character pattern to search for, passed as a
 102:    *                <code>String</code>.
 103:    * @param start The index into this <code>Clob</code> to start searching
 104:    *              (indices start at 1).
 105:    * @return The index at which the pattern was found (indices start at 1), or
 106:    *         -1 if the pattern was not found.
 107:    * @exception SQLException If an error occurs.
 108:    * @since 1.2
 109:    */
    long position(String pattern, long start) throws SQLException;
  
    /**
 113:    * This method returns the index into this <code>Clob</code> of the first
 114:    * occurrence of the specified character pattern (supplied by the caller as a
 115:    * <code>Clob</code>). The search begins at the specified index.
 116:    * 
 117:    * @param pattern The character pattern to search for, passed as a
 118:    *                <code>Clob</code>.
 119:    * @param start The index into this <code>Clob</code> to start searching
 120:    *              (indices start at 1).
 121:    * @return The index at which the pattern was found (indices start at 1), or
 122:    *         -1 if the pattern was not found.
 123:    * @exception SQLException If an error occurs.
 124:    * @since 1.2
 125:    */
    long position(Clob pattern, long start) throws SQLException;
  
    /**
 129:    * Writes the specified string into this <code>Clob</code>, starting at the
 130:    * specified index.
 131:    * 
 132:    * @param start The index at which the writing starts.
 133:    * @param value The string to write.
 134:    * @return The number of characters written.
 135:    * @exception SQLException If an error occurs.
 136:    * @since 1.4
 137:    */
    int setString(long start, String value) throws SQLException;
  
    /**
 141:    * Writes the specified portion of a string into this <code>Clob</code>,
 142:    * starting at the specified index.
 143:    * 
 144:    * @param startWrite The index at which the writing starts.
 145:    * @param value The string to write a portion of.
 146:    * @param startRead The offset into the string where the portion to copy
 147:    *                  starts.
 148:    * @param count The number of characters to write.
 149:    * @return The number of characters written.
 150:    * @exception SQLException If an error occurs.
 151:    * @since 1.4
 152:    */
    int setString(long startWrite, String value, int startRead, int count)
        throws SQLException;
  
    /**
 157:    * Returns an ASCII text stream that writes into this <code>Clob</code>,
 158:    * starting at the specified index.
 159:    * 
 160:    * @param start The index at which the writing starts.
 161:    * @return An ASCII text stream to write into this <code>Clob</code>.
 162:    * @exception SQLException If an error occurs.
 163:    * @since 1.4
 164:    */
    OutputStream setAsciiStream(long start) throws SQLException;
  
    /**
 168:    * Returns a character stream that writes into this <code>Clob</code>,
 169:    * starting at the specified index.
 170:    * 
 171:    * @param start The index at which the writing starts.
 172:    * @return A character stream to write into this <code>Clob</code>.
 173:    * @exception SQLException If an error occurs.
 174:    * @since 1.4
 175:    */
    Writer setCharacterStream(long start) throws SQLException;
  
    /**
 179:    * Truncates this <code>Clob</code> to be at most the specified number of
 180:    * characters long.
 181:    * 
 182:    * @param count The length this <code>Clob</code> is truncated to.
 183:    * @exception SQLException If an error occurs.
 184:    * @since 1.4
 185:    */
    void truncate(long count) throws SQLException;
  }
