(ns leiningen.new.cljs-template
    (:require [clojure.java.io :as io])
    (:use leiningen.new.templates))

(def render (renderer "cljs_template"))

(defn cljs-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["src/clj/{{sanitized}}/handler.clj" (render "handler.clj" data)]
             ["src/clj/{{sanitized}}/handlers/content.clj" (render "handlers/content.clj" data)]
             ["src/clj/{{sanitized}}/handlers/api.clj" (render "handlers/api.clj" data)]
             ["src/clj/{{sanitized}}/support/cors.clj" (render "support/cors.clj" data)]
             ["src/clj/{{sanitized}}/views/content.clj" (render "views/content.clj" data)]
             ["src/clj/{{sanitized}}/views/base.clj" (render "views/base.clj" data)]
             ["src/clj/{{sanitized}}/middlewares/wrap_dir_index.clj" (render "middlewares/wrap_dir_index.clj" data)]

             ; ClojureScript
             ["src/cljs/{{sanitized}}/main.cljs" (render "main.cljs" data)]

             ; Images
             ["resources/public/images/clojure.svg" (render "images/clojure.svg")]

             ; Bootstrap
             ;["resources/public/css/bootstrap-theme.min.css"             (render "bootstrap/css/bootstrap-theme.min.css")]
             ["resources/public/css/bootstrap.min.css"                   (render "bootstrap/css/bootstrap.min.css")]
             ["resources/public/js/bootstrap.min.js"                     (render "bootstrap/js/bootstrap.min.js")]
             ["resources/public/fonts/glyphicons-halflings-regular.eot"  (render "bootstrap/fonts/glyphicons-halflings-regular.eot")]
             ["resources/public/fonts/glyphicons-halflings-regular.svg"  (render "bootstrap/fonts/glyphicons-halflings-regular.svg")]
             ["resources/public/fonts/glyphicons-halflings-regular.ttf"  (render "bootstrap/fonts/glyphicons-halflings-regular.ttf")]
             ["resources/public/fonts/glyphicons-halflings-regular.woff" (render "bootstrap/fonts/glyphicons-halflings-regular.woff")]
             ;["resources/publis/js"]
             )))
