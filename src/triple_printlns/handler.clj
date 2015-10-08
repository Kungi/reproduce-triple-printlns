(ns triple-printlns.handler
  (:require [compojure.core :as compojure :refer [GET]]
            [com.stuartsierra.component :as component]
            [ring.adapter.jetty :as jetty]))

(compojure/defroutes app
  (GET "/foo" [] (println "Fooo!!!")))

(defrecord Routes []
  component/Lifecycle

  (start [this]
    (let [server (jetty/run-jetty app {:port 3333 :join? false})]
      (assoc this :server server)))

  (stop [this]
    (.stop (:server this))
    (dissoc this :server)))
