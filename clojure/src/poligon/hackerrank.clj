(ns poligon.hackerrank)

(defn solve-me-first
  "Solution to https://www.hackerrank.com/challenges/fp-solve-me-first"
  []
  (println (+ (Integer/parseInt (read-line))
              (Integer/parseInt (read-line)))))

;; Solution to "Hello World N Times":
;; (fn [n] (dotimes [_ n] (println "Hello World")))

;; Solution to "List Replication"
;; https://www.hackerrank.com/challenges/fp-list-replication
;; (mapcat #(repeat num %) lst)

;; Solution to "Filter Array"
;; https://www.hackerrank.com/challenges/fp-filter-array
(defn filter-array [n nums]
  (reduce #(if (< %2 n) (conj % %2) %) [] nums))

;; https://www.hackerrank.com/challenges/fp-reverse-a-list
(defn reverse-a-list
  [lst]
  (reduce conj '() lst))

;; https://www.hackerrank.com/challenges/fp-list-length
;; (fn [lst] (reduce (fn [n _] (inc n)) 0 lst))

;; Update list:
;; (fn [nums] (map #(Math/abs %) nums))

(defn do-lines-string
  "Read number of input lines N and executes function F N times."
  [f]
  (dotimes [i (Integer/parseInt (read-line))]
    (println (f (.split (read-line) " ")))))

(defn do-lines-long
  "Read whole input and executes function F on lines from 2nd to the end."
  [f lines]
  (let [i (Integer/parseInt (read-line))]
    (reduce #(conj % (f %2)) [] )
    (doseq [line (rest lines)]
      (println (f (Long/parseLong line))))))

(defn ->numbers-vec [s]
  (mapv #(Integer/valueOf %) (.split s " ")))

;; (for [i (range (Integer/parseInt (read-line)))
;;       x (Double/parseDouble (read-line))])

(defn read-input
  "Read whole input and executes function F on lines from 2nd to the end."
  [f]
  (let [lines (seq (.split (slurp *in*) "\n"))]
    (map f (rest lines))))

(defn solve-me-second
  "Solution to https://www.hackerrank.com/challenges/solve-me-second"
  [nums]
  (reduce #(+ % (Integer/parseInt %2)) 0 nums))

(defn lonely-integer
  "Solution to https://www.hackerrank.com/challenges/lonely-integer"
  [nums]
  (ffirst (filter #(= (val %) 1) (frequencies nums))))

(defn alternating-characters
  "Solution to https://www.hackerrank.com/challenges/alternating-characters"
  [ar]
  (second (reduce #(if (= (first %) %2)
                     [(first %) (inc (second %))]
                     [%2 (second %)])
                  [0 0] (first ar))))

(defn utopian-tree-size
  "Utopian tree grows in monsoon season * 2, and in summer by +1 meter.
  Starts with 1 meter, before monsoon. How many meters will it have after
  given number of seasons.
  See https://www.hackerrank.com/challenges/utopian-tree"
  ([seasons] (utopian-tree-size seasons 1))
  ([seasons meters]
   (if (> seasons 0)
     (recur (dec seasons)
            (if (even? meters) (inc meters) (* meters 2)))
     meters)))

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

(defn flipping-bits
  "Return a number resulting from flipping bits.
  See https://www.hackerrank.com/challenges/flipping-bits"
  [x]
  (loop [i 0 x x]
    (if (= i 32)
      x
      (recur (inc i) (bit-flip x i)))))

(defn maximizing-xor
  "Find maximal XOR value.
  See https://www.hackerrank.com/challenges/maximizing-xor"
  ([] (println
       (maximizing-xor (Integer/parseInt (read-line))
                       (Integer/parseInt (read-line)))))
  ([a b]
   (apply max
          (for [i (range a (inc b)) j (range i (inc b))]
            (bit-xor i j)))))

(defn angry-professor
  "Will angry professor cancell the class?
  See https://www.hackerrank.com/challenges/angry-professor"
  ([] (angry-professor (slurp *in*)))
  ([s] (let [lines (seq (.split s "\n"))
             cases (rest lines)]
         (loop [cases cases]
           (when (seq cases)
             (let [[_ min-students] (clojure.string/split (first cases) #" ")
                   tseq (map #(Integer/parseInt %)
                             (clojure.string/split (second cases) #" "))]
               (println (angry-professor (Integer/parseInt min-students) tseq))
               (recur (drop 2 cases)))))))
  ([min-required tseq]
   (if (<= min-required (count (filter (complement pos?) tseq)))
     "NO"
     "YES")))

(defn pangrams [s]
  "Solution to https://www.hackerrank.com/challenges/pangrams"
  (let [n (->> (.toLowerCase (read-line))
               (filter #(Character/isLowerCase %))
               (into #{})
               (count))]
    (if (= 26 n)
      (println "pangram")
      (println "not pangram"))))

(defn- valleys-counter [[n level] step]
  (let [step-val (if (= step \D) -1 1)
        level (+ level step-val)]
    (if (= level step-val -1)
      [(inc n) level]
      [n level])))

(defn count-valleys
  "Solution to https://www.hackerrank.com/challenges/counting-valleys"
  [s]
  (first (reduce valleys-counter [0 0] s)))

(defn service-lane
  "Solution to https://www.hackerrank.com/challenges/service-lane"
  [lines segment]
  (let [widths (->numbers-vec lines)]
    (let [[from to] (->numbers-vec segment)]
      (reduce min (subvec widths from (inc to))))))

;; (let [[n t] (->numbers-vec (read-line)) ;; number of widths and segments
;;       widths (->numbers-vec (read-line))]
;;   (dotimes [_ t]
;;     (println (service-lane widths (read-line)))))

(defn plus-minus
  "Solution to https://www.hackerrank.com/challenges/plus-minus"
  [nums]
  (let [groups (group-by (fn [x] (cond
                                   (pos? x) :positive
                                   (zero? x) :zero
                                   (neg? x) :negative)) nums)
        n (count nums)
        npos (count (:positive groups))]
    (printf "%.6f%n" (double (/ (count (:positive groups)) n)))
    (printf "%.6f%n" (double (/ (count (:negative groups)) n)))
    (printf "%.6f%n" (double (/ (count (:zero groups)) n)))))

(defn staircase
  "Solution to https://www.hackerrank.com/challenges/staircase"
  [n]
  (dotimes [row n]
    (dotimes [space (- n row 1)] (print \space))
    (dotimes [h (inc row)] (print \#))
    (println)))

(defn- sum-in-row [i row]
  (let [parts (.split row " ")]
    (- (Integer/parseInt (get parts i))
       (Integer/parseInt (get parts (- (count parts) i 1))))))

(defn diagonal-difference
  "Solution to https://www.hackerrank.com/challenges/diagonal-difference"
  [arr]
  (Math/abs (reduce + (map-indexed sum-in-row arr))))
;; (let [n (Integer/parseInt (read-line))
;;       arr (.split (slurp *in*) "\n")]
;;   (print (diagonal-difference arr)))

(defn- sum-with-min-max [arr]
  (reduce (fn [[sum minn maxn] x]
            [(+ sum x) (Math/min minn x) (Math/max maxn x)])
          [0 Integer/MAX_VALUE Integer/MIN_VALUE]
          arr))

(defn mini-max-sum
  "Solution to https://www.hackerrank.com/challenges/mini-max-sum"
  [arr]
  (let [[sum min-val max-val] (sum-with-min-max arr)
        smallest-sum (- sum max-val)
        largest-sum (- sum min-val)]
    [smallest-sum largest-sum]))

(defn birthday-cake-candles
  "https://www.hackerrank.com/challenges/birthday-cake-candles"
  [arr]
  (first
   (reduce (fn [[n x] y]
             (cond
               (= x y) [(inc n) x]
               (> x y) [n x]
               :else [1 y]))
           [0 0]
           arr)))

(defn birthday-cake-candles-loop
  "https://www.hackerrank.com/challenges/birthday-cake-candles"
  [candles]
  (let [n (count candles)]
    (loop [i 0 x 0 xes 0]
      (if (< i n)
        (let [y (get candles i)]
          (cond
            (= x y) (recur (inc i) x (inc xes))
            (> x y) (recur (inc i) x xes)
            :else (recur (inc i) y 1)))
        xes))))

(defn- can-jump? [n clouds i]
  (and (< i n)
       (zero? (get clouds i))))

(defn jumping-on-clouds
  "https://www.hackerrank.com/challenges/jumping-on-the-clouds"
  [n clouds]
  (loop [i 0 jumps 0]
    (cond
      (can-jump? n clouds (+ i 2)) (recur (+ i 2) (inc jumps))
      (can-jump? n clouds (+ i 1)) (recur (+ i 1) (inc jumps))
      :else jumps)))

(defn- count-as [s]
  (count (filter #(= \a %) s)))

(defn repeated-string
  "https://www.hackerrank.com/challenges/repeated-string"
  [s n]
  (let [len (count s)
        a-cnt (count-as s)]
    (+ (* a-cnt (quot n len))
       (count-as (take (rem n len) s)))))
