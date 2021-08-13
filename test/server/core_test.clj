(ns server.core-test
  (:require [clojure.test :refer :all]
            [queries.query :as query]
            [ring.mock.request :as mock]
            [ring.util.http-status :refer :all]
            [server.core :refer :all]))



(deftest create-customer
 (testing "Creating customer"
    (def createdCustomer {:Name "Nikola", :LastName "Jokic", :City "Sombor"})
    (let [customer (query/add-customer createdCustomer)
    exist-customer (query/get-customer (customer :CustomerID))]
        (is (= "Jokic" (exist-customer :LastName)))
           )))

(deftest create-order
 (testing "Creating order"
  (def createdOrder {:TotalPayment 10000.0, :CustomerID 1, :ProductID 1, :TotalOrderOfSameProduct 10})
   (let [order (query/add-order createdOrder)
    exist-order (query/get-order (order :OrderID))]
     (is (= 10000.0 (exist-order :TotalPayment)))
    )))

       