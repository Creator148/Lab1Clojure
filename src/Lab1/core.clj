(ns Lab1.core)

(defn repeated [coll n]
  ((fn ff [seen xs]
     (lazy-seq
       (when-let [[y & ys] (seq xs)]
         (case (seen y)
           :several (ff seen ys)
           :once (if (>= n 2)
                   (cons y (ff (assoc seen y :several) ys))
                   (ff seen ys))
           (ff (assoc seen y :once) ys)))))
   {} coll))
(defn main []
  (println "Введите элементы списка (через пробел), затем n:")
  (let [input (read-line)
        parsed-input (clojure.string/split input #"\s+")
        n (-> (read-line) Integer.)]
    (prn (repeated parsed-input n) )))
(main)

