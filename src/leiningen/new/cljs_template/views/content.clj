(ns {{name}}.views.content
  (:require [clojure.string :as string]
            [hiccup.core :refer :all]
            [{{name}}.views.base :as base]))

(def scripts
  nil)

(def intro
  [:div.intro
   [:p
    "Clojure, Compojure, & ClojureScript Starter"]
   [:p
    [:a.learn-more
     {:href "/"}
     "Learn More"]]])

(def documentation-links-data
  [["http://compojure.org"
    "Compojure Docs"]
   ["http://github.com/clojure/clojurescript"
    "ClojureScript Repo"]])

(defn documentation-link [url title]
  [:a {:href url} title])

(def documentation-links
  (map (fn [[url title]] [:li (documentation-link url title)]) documentation-links-data))

(def popular-widget
  [:div.popular.widget
   [:h4 "Documentation"]
   [:ul documentation-links]])

(def sidebar
  [:div.large-3.columns.sidebar
   intro
   popular-widget])

(defn body [content]
  [:body.home
   [:div.contain-to-grid.sticky
    [:div.row base/navbar]]
   [:header.row
    [:div.large-12.columns
     [:h1
      [:a.zenbox
       {:href "/"}
       [:img {:src "/images/clojure.svg", :alt "Clojure App"}]]]]]
   [:section.blog
    [:div.row
     [:div.large-9.columns
      [:div.content
       content]]
     sidebar]]
   base/footer
   scripts])

(defn page [& content]
  (list "<!--[if IE 8]> <html class=\"no-js lt-ie9\" lang=\"en\"> <![endif]-->"
        "<!--[if gt IE 8]> ><! <![endif]-->"
        [:html.no-js
         {:lang "en"}
         "<!-- <![endif] -->"
         base/head
         (body content)]))

(def help*
  (list
   [:h1 "Getting Started Help"]
   [:p
    "For discussions, see the"
    [:a {:href "github"} "github page"]
    "."]))

(def help
  (html (page help*)))

(def home*
  (list [:h1 "Clojure & ClojureScript"]
        [:p "So good, you'll think it's alien technology."]
        [:p.alert.cljs-target]))

(def home
  (html (page home*)))

(def not-found*
  (list [:h1 "We couldn't find that page!"]
        [:p
         "What about checking out the "
         [:a {:href "/"} "homepage"]
         " instead?"]
        [:p "In the meantime, here's some nice music to relax with"]
        [:iframe
         {:allowfullscreen "allowfullscreen",
          :frameborder "0",
          :src "http://www.youtube.com/embed/5NRuD9Y0JQ0",
          :height "315",
          :width "560"}]))

(def not-found
  (html (page not-found*)))
