
(ns handler.handler
    (:require [compojure.api.sweet :refer :all]
              [ring.util.http-response :refer :all]
              [queries.query :as query]
              [schema.core :as schema]
              [domain.customer :refer :all]
              [domain.order :refer :all]
              [domain.product :refer :all]
              [domain.product_detail :refer :all]))
  (def auth)



(def app
    (api 
      {
        :swagger {
          :ui "/"
          :spec "/swagger.json"
          :data {
            :info { :title "Store" :description "CRUD Application"}
            :tags [
              {:name "customer", :description "Customer endpoint."}
            ]
          }
        }
      }

        
  (context "/customer" []
    :tags ["customer"]

    (GET "/" []
      :return [Customer]
      :summary "Get all customers"
      (ok (query/get-customers)))
    )))