(ns queries.query
    (:require [connection.mysqlconnection]
              [korma.core :refer :all]
              [korma.db :refer :all]
              [schema.core :as schema]
              [domain.customer :refer :all]
              [domain.order :refer :all]
              [domain.product :refer :all]
              [domain.product_detail :refer :all])
    (:import (java.security MessageDigest)))


    ;; Customer

    (defentity customer)

    (defn get-customers[]
        (select customer))
