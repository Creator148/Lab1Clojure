(ns Lab1.Lab1)

(defn repeated [coll n]
  (loop [seen {}
         xs coll
         result-seq []]
    (if-let [[y & ys] (seq xs)]
      (recur (update seen y (fnil inc 0))
             ys
             (if (= (get seen y) n)
               (conj result-seq y)
               result-seq))
      (lazy-seq result-seq))))
(defn main []
  (println "Введите элементы списка (через пробел), затем n:")
  (let [input (read-line)
        parsed-input (clojure.string/split input #"\s+")
        n (-> (read-line) Integer.)]
    (prn (repeated parsed-input n) )))
(main)
