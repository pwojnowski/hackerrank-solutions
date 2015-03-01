(ns poligon.hackerrank)

(defn do-lines
  "Read number of input lines N and reads executes function F N times."
  [f]
  (dotimes [i (Integer/parseInt (read-line))]
    (println (f (.split (read-line) " ")))))

(defn solve-me-second
  "Solution to https://www.hackerrank.com/challenges/solve-me-second"
  [nums]
  (reduce #(+ % (Integer/parseInt %2)) 0 nums))

(defn lonely-integer
  "Solution to https://www.hackerrank.com/challenges/lonely-integer"
  [nums]
  (first (first (filter #(= (val %) 1) (frequencies nums)))))

(defn alternating-characters
  "Solution to https://www.hackerrank.com/challenges/alternating-characters"
  [ar]
  (second (reduce #(if (= (first %) %2)
                     [(first %) (inc (second %))]
                     [%2 (second %)])
                  [0 0] (first ar))))

(defn utopian-tree-size
  ([seasons] (utopian-tree-size seasons 1))
  ([seasons meters]
     (if (> seasons 0)
       (recur (dec seasons)
              (if (even? meters) (inc meters) (* meters 2)))
       meters)))

(defn utopian-tree
  "Utopian tree grows in monsoon season * 2, and in summer by +1 meter.
Starts with 1 meter, before monsoon. How many meters will it have after
given number of seasons.
See https://www.hackerrank.com/challenges/utopian-tree"
  []
  (let [lines (seq (.split (slurp *in*) "\n"))]
    (doseq [line (rest lines)]
      (println (utopian-tree-size (Integer/parseInt line))))))

(defn game-of-thrones
  "Check if given string can be turned into palindrome.
See https://www.hackerrank.com/challenges/game-of-thrones."
  [s]
  (if (> 2 (count (filter #(odd? (val %)) (frequencies s))))
    "YES" "NO"))

(defn is-fibo
  "Determine if `n' is an element of the Fibonacci Sequence.
See https://www.hackerrank.com/challenges/is-fibo"
  [n]
  (loop [prev 2 current 3]
    (cond (<= n 3) "IsFibo"
          (= current n) "IsFibo"
          (< n current) "IsNotFibo"
          :else (recur current (+ prev current)))))

(defn is-fibo-runner
  []
  (let [lines (seq (.split (slurp *in*) "\n"))]
    (doseq [line (rest lines)]
      (println (is-fibo (Long/parseLong line))))))
