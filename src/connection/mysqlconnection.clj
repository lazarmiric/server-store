(ns database.database
    (:require [korma.db :as korma]))
  
  
  (def db-connection (korma/mysql {:classname   "com.mysql.cj.jdbc.Driver"
                                   :subprotocol "mysql"
                                   :user        "root"
                                   :password    "32209Car."
                                   :subname     "//localhost:3306/storedb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"}))
  
  (korma/defdb db db-connection)