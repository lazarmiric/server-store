(ns database.database
    (:require [korma.db :as korma]))
  
  
  (def db-connection (korma/mysql {:classname   "com.mysql.cj.jdbc.Driver"
                                   :subprotocol "mysql"
                                   :user        "root"
                                   :password    "32209Car."
                                   :subname     "//localhost:3306/storedb"}))
  
  (korma/defdb db db-connection)