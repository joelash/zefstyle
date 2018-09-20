(ns zefstyle.core
  (:require
    [reagent.core :as reagent :refer [atom]]))

;; -------------------------
;; Views

(def react-player
  (reagent/adapt-react-class js/ReactPlayer))


(defn home-page []
  [:div
     [:h2 "Zef Style"]
     [react-player {:url "https://www.youtube.com/watch?v=BU2d5av-k6Q&feature=player_embedded_uturn"}]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
