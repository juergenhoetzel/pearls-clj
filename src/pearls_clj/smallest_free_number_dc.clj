(ns pearls-clj.smallest-free-number-dc)

(declare minfrom)

(defn smallest-free-number [xs]
  (minfrom 0 [(count xs) xs]))


(defn partition-hsk [pred coll]
  "Haskells partition function, not lazy"
  (loop [xs [] ys[] coll coll]
    (cond (not (seq coll)) [xs ys]
          (pred (first coll)) (recur (conj xs (first coll)) ys (rest coll))
          :else (recur xs (conj ys (first coll)) (rest coll)))))

(defn minfrom [a [n xs]]
  (let [b (+ a 1 (quot n 2))
        [us vs] (partition-hsk (partial > b) xs)
        m (count us)]
    (cond
      (zero? n) a
      (= m (- b a)) (recur b [(- n m) vs])
      :else (recur a [m us]))))