(ns Lab2.Lab2 (:require [clojure.core.async :as a]))

(def chan1 (a/chan 10))
(a/onto-chan! chan1 [5 4 8 12 9 -2 8 3 1 0])
(def chan2 (a/chan 10))

(defn new_abs [n] (max n (- n)))

(defn value_difference [chan1 chan2 n]
  (a/go (loop [previous (a/<! chan1)]
          (when-some [value (a/<! chan1)]
            (when (<= n  (new_abs (- value previous)))
              (println "sent" value)
              (a/>! chan2 value))

            (recur value)))))


(value_difference chan1 chan2 2)
