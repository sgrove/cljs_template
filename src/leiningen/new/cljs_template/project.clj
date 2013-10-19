(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :plugins [[lein-ancient "0.4.4"]
            [lein-cljsbuild "0.3.4"]
            [lein-ring "0.8.7"]]
  :dependencies [[com.cemerick/piggieback "0.1.0"]
                 [compojure "1.1.5"]
                 [prismatic/dommy "0.1.2"]
                 [hiccup "1.0.4"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]
                 [org.clojure/tools.reader "0.7.9"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-json "0.2.0"]
                 [ring/ring-jetty-adapter "1.2.0"]]
  :ring {:handler {{name}}.handler/app}
  :source-paths ["src/clj"
                 "src/cljs"]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :cljsbuild {:builds
              [{:source-paths ["src/cljs"],
                :id "dev",
                :compiler {:pretty-print true,
                           :output-dir "resources/public/js/bin-debug",
                           :output-to "resources/public/js/bin-debug/main.js",
                           :optimizations :simple
                           ;:source-map "resources/public/js/bin-debug/main.js.map"
                           }}
               {:source-paths ["src/cljs"
                               "test-cljs"],
                :id "test",
                :compiler {:pretty-print true,
                           :output-to "resources/private/js/unit-test.js",
                           :optimizations :whitespace
                           ;:source-map "resources/public/js/bin-debug/main.map"
                           }
                }
               {:source-paths ["src/cljs"],
                :id "prod",
                :compiler {:pretty-print false,
                           :output-dir "resources/public/js/bin",
                           :output-to "resources/public/js/bin/main.js",
                           :debug true,
                           :optimizations :advanced
                           ;:source-map "resources/public/js/bin/main.js.map"
                           }}],
              :repl-listen-port 9000}
  :main ^{:skip-aot true} {{name}}.server)
