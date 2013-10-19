(ns {{name}}.views.base
  (:require [clojure.string :as string]
            [hiccup.core :refer :all]))

(def head
  [:head
   [:meta
    {:content "text/html ; charset=utf-8", :http-equiv "Content-Type"}]
   [:meta
    {:content "initial-scale=1.0, user-scalable=yes"
     :name "viewport"}]
   [:title "Clojure & ClojureScript"]
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport", :content "width=device-width"}]
   [:link {:rel "stylesheet", :href "/css/bootstrap.min.css"}]
   [:script
    {:src
     "//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"}]
   [:script {:src "/js/bootstrap.min.js"}]
   [:script {:src "/js/bin-debug/main.js"}]
   [:link
    {:type "text/css"
     :rel "stylesheet"
     :href
     "https://fonts.googleapis.com/css?family=Lato:300,700,300italic,700italic"}]
   [:link
    {:href
     "https://chrome.google.com/webstore/detail/mlkjemamfkkbldipgchdhfghamhmdchg"
     :rel "chrome-webstore-item"}]
   [:link
    {:href "/images/favicon.ico"
     :type "image/x-icon"
     :rel "shortcut icon"}]
   "<!--[if lt IE 9]>\n        <link rel=\"stylesheet\" href=\"stylesheets/ie.css\" media=\"screen\">\n        <script src=\"javascripts/selectivizr-min.js\"></script>\n        <![endif]-->"])

(def navbar
  [:nav.navbar.navbar-default {:role "navigation"}
                                        ; Brand and toggle get grouped for better mobile display 
   [:div.navbar-header
    [:button.navbar-toggle {:type "button" :data-toggle "collapse" :data-target ".navbar-ex1-collapse"}
     [:span.sr-only "Toggle navigation"]
     [:span.icon-bar]
     [:span.icon-bar]
     [:span.icon-bar]]
    [:a.navbar-brand {:href "#"} [:img {:src "/images/clojure.svg"
                                        :style "max-height: 20px;"}]]]
                                        ; Collect the nav links, forms, and other content for toggling
   [:div.collapse.navbar-collapse.navbar-ex1-collapse
    [:ul.nav.navbar-nav
     [:li.active
      [:a {:href "#"} "Link"]]
     [:li
      [:a {:href "#"} "Link"]]
     [:li.dropdown
      [:a.dropdown-toggle {:href "#" :data-toggle "dropdown"} "Dropdown"
       [:b.caret]]
      [:ul.dropdown-menu
       [:li [:a {:href "#"} "Action"]]
       [:li [:a {:href "#"} "Another action"]]
       [:li [:a {:href "#"} "Something else here"]]
       [:li [:a {:href "#"} "Separated link"]]
       [:li [:a {:href "#"} "One more separated link"]]]]]]])

(def footer
  [:footer.row
   [:div.large-12.columns
    [:p
     "COPYRIGHT © {{year}} {{company}} | "
     [:a
      {:target "_blank", :href "/blog/index.html"}
      "BLOG"]
     " | "
     [:a {:href "www.zenboxa/team"} "TEAM"]
     " | "
     [:a {:href "/jobs"} "JOBS"]
     " | "
     [:a {:href "/faq"} "FAQ"]
     " | "
     [:a {:href "/help"} "HELP"]]]])
