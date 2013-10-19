(ns {{name}}.handlers.content
  (:use [compojure.core])
  (:require [compojure.route :as route]
            [{{name}}.middlewares.wrap-dir-index :refer [wrap-dir-index]]
            [{{name}}.views.content :as content]))

(defroutes content-routes*
  (GET "/" [] content/home)
  (GET "/help" [] content/help)
  (route/resources "/"))

(def content-routes
  (wrap-dir-index content-routes*))

