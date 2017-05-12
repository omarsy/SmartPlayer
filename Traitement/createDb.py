import sqlite3
conn = sqlite3.connect('server.db')
c = conn.cursor()

# Create table
c.execute("CREATE TABLE son (id Integer Primary key Autoincrement,album text, titre text, artist text)")

# Save (commit) the changes
conn.commit()

# We can also close the connection if we are done with it.
# Just be sure any changes have been committed or they will be lost.
conn.close()
