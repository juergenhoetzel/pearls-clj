(ns pearls-clj.smallest-free-number-dc)

(declare minfrom)

(defn smallest-free-number [xs]
  (minfrom 0 [count xs, xs]))

(defn minfrom [a [n xs]]
  (let [b (quot (+ a 1 n) 2)
        [us vs] (partition-by (partial >= b) xs)
        m (count us)
        ] (cond
            (zero? n) a
            (= m (- b a)) (recur b [(- n m) vs])
            :else (recur a [m us]))))