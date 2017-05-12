# import the Flask class from the flask module
from flask import Flask, render_template, redirect, url_for, request
import sqlite3
import time

# create the application object
app = Flask(__name__)


# use decorators to link the function to a url
@app.route('/')
def home():
   
    return render_template('machines.html')



# start the server with the 'run()' method
if __name__ == '__main__':
    app.run(host = '0.0.0.0', debug = True,port=9090)

