 package java.sql.start;
   
   import java.io.InputStream;
   import java.io.OutputStream;
   
   /**
  44:  * This interface specified methods for accessing a SQL BLOB (Binary Large
  45:  * OBject) type.
  46:  * 
  47:  * @author Aaron M. Renn (arenn@urbanophile.com)
  48:  * @since 1.2
  49:  */
   public interface Blob
   {
     /**
  53:    * This method returns the number of bytes in this <code>Blob</code>.
  54:    * 
  55:    * @return The number of bytes in this <code>Blob</code>.
  56:    * @exception SQLException If an error occurs.
  57:    */
     long length() throws SQLException;
  
     /**
  61:    * This method returns up to the requested bytes of this <code>Blob</code>
  62:    * as a <code>byte</code> array.
  63:    * 
  64:    * @param start The index into this <code>Blob</code> to start returning
  65:    *              bytes from.
  66:    * @param count The requested number of bytes to return.
  67:    * @return The requested bytes from this <code>Blob</code>.
  68:    * @exception SQLException If an error occurs.
  69:    */
     byte[] getBytes(long start, int count) throws SQLException;
   
     /**
  73:    * This method returns a stream that will read the bytes of this
  74:    * <code>Blob</code>.
  75:    * 
  76:    * @return A stream that will read the bytes of this <code>Blob</code>.
  77:    * @exception SQLException If an error occurs.
  78:    */
     InputStream getBinaryStream() throws SQLException;
   
     /**
  82:    * This method returns the index into this <code>Blob</code> at which the
  83:    * first instance of the specified bytes occur. The searching starts at the
  84:    * specified index into this <code>Blob</code>.
  85:    * 
  86:    * @param pattern The byte pattern to search for.
  87:    * @param start The index into this <code>Blob</code> to start searching for
  88:    *              the pattern.
  89:    * @return The offset at which the pattern is first found, or -1 if the
  90:    *         pattern is not found.
  91:    * @exception SQLException If an error occurs.
  92:    */
     long position(byte[] pattern, long start) throws SQLException;
   
     /**
  96:    * This method returns the index into this <code>Blob</code> at which the
  97:    * first instance of the specified pattern occurs. The searching starts at the
  98:    * specified index into this <code>Blob</code>. The bytes in the specified
  99:    * <code>Blob</code> are used as the search pattern.
 100:    * 
 101:    * @param pattern The <code>Blob</code> containing the byte pattern to
 102:    *                search for.
 103:    * @param start The index into this <code>Blob</code> to start searching for
 104:    *              the pattern.
 105:    * @return The offset at which the pattern is first found, or -1 if the
 106:    *         pattern is not found.
 107:    * @exception SQLException If an error occurs.
 108:    */
    long position(Blob pattern, long start) throws SQLException;
  
    /**
 112:    * Writes the specified data into this <code>Blob</code>, starting at the
 113:    * specified index.
 114:    * 
 115:    * @param start The index at which the writing starts.
 116:    * @param bytes The data to write.
 117:    * @exception SQLException If an error occurs.
 118:    * @since 1.4
 119:    */
    int setBytes(long start, byte[] bytes) throws SQLException;
  
    /**
 123:    * Writes a portion of the specified data into this <code>Blob</code>,
 124:    * starting at the specified index.
 125:    * 
 126:    * @param startWrite The index into this <code>Blob</code> at which writing
 127:    *                   starts.
 128:    * @param bytes The data to write a portion of.
 129:    * @param startRead The offset into the data where the portion to copy starts.
 130:    * @param count The number of bytes to write.
 131:    * @exception SQLException If an error occurs.
 132:    * @since 1.4
 133:    */
    int setBytes(long startWrite, byte[] bytes, int startRead, int count)
        throws SQLException;
  
    /**
 138:    * Returns a binary stream that writes into this <code>Blob</code>,
 139:    * starting at the specified index.
 140:    * 
 141:    * @param start The index at which the writing starts.
 142:    * @return A binary stream to write into this <code>Blob</code>.
 143:    * @exception SQLException If an error occurs.
 144:    * @since 1.4
 145:    */
    OutputStream setBinaryStream(long start) throws SQLException;
  
    /**
 149:    * Truncates this <code>Blob</code> to be at most the specified number of
 150:    * bytes long.
 151:    * 
 152:    * @param count The length this <code>Blob</code> is truncated to.
 153:    * @exception SQLException If an error occurs.
 154:    * @since 1.4
 155:    */
    void truncate(long count) throws SQLException;
  }
