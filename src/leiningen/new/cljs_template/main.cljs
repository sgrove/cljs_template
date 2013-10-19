(ns {{name}}.client.main
    (:require [clojure.browser.repl :as repl]
              [dommy.utils :as utils]
              [dommy.core :as dommy])
    (:use-macros
     [dommy.macros :only [node sel sel1]]))

(.log js/console "Running ClojureScript inside of {{name}}")

;;************************************************
;; Dev stuff
;;************************************************

(defn ^:export nrepl []
  (repl/connect "http://localhost:9000/repl"))

(set! (.-nrepl js/window)
      nrepl)

(defn greet! []
  (when-let [el (sel1 :.cljs-target)]
    (dommy/set-text! el "ClojureScript Loaded!")))

(set! (.-onload js/window) greet!)
