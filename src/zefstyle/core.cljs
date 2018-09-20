(ns zefstyle.core
  (:require
    [reagent.core :as reagent :refer [atom]]
    [react-player]))

;; -------------------------
;; Views

(def react-player-comp
  (do
    (js/console.warn react-player/ReactPlayer)
    (reagent/adapt-react-class react-player/ReactPlayer)))


(defn home-page []
  [:div
     [:h2 "Zef Style"]
     [react-player-comp {:url "https://www.youtube.com/watch?v=BU2d5av-k6Q&feature=player_embedded_uturn"}]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
