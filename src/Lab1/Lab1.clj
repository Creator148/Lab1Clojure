(ns Lab1.Lab1)

(defn repeated [coll n]
  (loop [seen {}
         xs (seq coll)
         result []]
    (if-let [[y & ys] xs]
      (let [current-count (get seen y 0)]
        (recur (update seen y (fn [x] (if x (inc x) 1))) ys
               (if (>= current-count n) (conj result y) result)))
      result)))

(defn main []
  (println "Введите элементы списка (через пробел), затем n:")
  (let [input (read-line)
        parsed-input (clojure.string/split input #"\s+")
        n (-> (read-line) Integer.)]
    (prn (repeated parsed-input n) )))
(main)

