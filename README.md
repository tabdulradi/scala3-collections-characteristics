# scala3-collections-characteristics
Some benchmarks against Scala 3 collections (which is also the same for Scala 2.13)
Part of my Scala 3 training material. All rights reserved.


## Results from my puny little laptop

[info] Benchmark                                             Mode  Cnt           Score           Error  Units
[info] c.a.b.s.c.immutable.Maps.baseline                    thrpt    5  3931509127.171 ±  17243309.775  ops/s
[info] c.a.b.s.c.immutable.Maps.hashMapAdd                  thrpt    5    15694294.458 ±    763144.266  ops/s
[info] c.a.b.s.c.immutable.Maps.hashMapConcat               thrpt    5   163176909.979 ±   8556187.951  ops/s
[info] c.a.b.s.c.immutable.Maps.hashMapContainsExisting     thrpt    5   110460075.163 ±   3216072.220  ops/s
[info] c.a.b.s.c.immutable.Maps.hashMapContainsNonExisting  thrpt    5   201810104.912 ±   9049003.533  ops/s
[info] c.a.b.s.c.immutable.Maps.hashMapRemove               thrpt    5    20700132.541 ±    552195.794  ops/s
[info] c.a.b.s.c.immutable.Maps.listMapAdd                  thrpt    5      823148.968 ±   2235943.840  ops/s
[info] c.a.b.s.c.immutable.Maps.listMapConcat               thrpt    5       33083.571 ±      1142.885  ops/s
[info] c.a.b.s.c.immutable.Maps.listMapContainsExisting     thrpt    5     7553890.215 ±    142642.847  ops/s
[info] c.a.b.s.c.immutable.Maps.listMapContainsNonExisting  thrpt    5     1838567.728 ±     57827.945  ops/s
[info] c.a.b.s.c.immutable.Maps.listMapRemove               thrpt    5      359510.567 ±    324906.128  ops/s
[info] c.a.b.s.c.immutable.Maps.treeMapAdd                  thrpt    5     2394661.758 ±   1462611.742  ops/s
[info] c.a.b.s.c.immutable.Maps.treeMapConcat               thrpt    5    65626493.669 ±   1354256.362  ops/s
[info] c.a.b.s.c.immutable.Maps.treeMapContainsExisting     thrpt    5    10129332.230 ±     48128.079  ops/s
[info] c.a.b.s.c.immutable.Maps.treeMapContainsNonExisting  thrpt    5     6474847.700 ±    272383.857  ops/s
[info] c.a.b.s.c.immutable.Maps.treeMapRemove               thrpt    5     3567683.925 ±     31618.563  ops/s
[info] c.a.b.s.c.immutable.Seqs.baseline                    thrpt    5   787663380.078 ±   4038058.867  ops/s
[info] c.a.b.s.c.immutable.Seqs.linkedListConcat            thrpt    5           2.929 ±         1.577  ops/s
[info] c.a.b.s.c.immutable.Seqs.linkedListHead              thrpt    5    84563367.963 ±   3947979.640  ops/s
[info] c.a.b.s.c.immutable.Seqs.linkedListLast              thrpt    5           6.431 ±         0.059  ops/s
[info] c.a.b.s.c.immutable.Seqs.linkedListTail              thrpt    5    79093341.333 ±    244879.137  ops/s
[info] c.a.b.s.c.immutable.Seqs.listAppend                  thrpt    5           2.683 ±         1.830  ops/s
[info] c.a.b.s.c.immutable.Seqs.listMap                     thrpt    5           3.208 ±         2.080  ops/s
[info] c.a.b.s.c.immutable.Seqs.listPrepend                 thrpt    5   219179355.045 ±   6954509.382  ops/s
[info] c.a.b.s.c.immutable.Seqs.vectorAppend                thrpt    5    33708056.774 ±   1679063.775  ops/s
[info] c.a.b.s.c.immutable.Seqs.vectorConcat                thrpt    5          39.856 ±         0.513  ops/s
[info] c.a.b.s.c.immutable.Seqs.vectorHead                  thrpt    5   368155171.063 ±  19229293.667  ops/s
[info] c.a.b.s.c.immutable.Seqs.vectorLast                  thrpt    5   344743446.678 ±   4318846.983  ops/s
[info] c.a.b.s.c.immutable.Seqs.vectorMap                   thrpt    5          14.831 ±         0.450  ops/s
[info] c.a.b.s.c.immutable.Seqs.vectorPrepend               thrpt    5    11842221.326 ±    317188.863  ops/s
[info] c.a.b.s.c.immutable.Seqs.vectorTail                  thrpt    5    48107423.653 ±    845698.677  ops/s
[info] c.a.b.s.c.mutable.Maps.baseline                      thrpt    5  3944712061.268 ±  41034265.912  ops/s
[info] c.a.b.s.c.mutable.Maps.hashMapAdd                    thrpt    5    15672635.102 ±    550473.238  ops/s
[info] c.a.b.s.c.mutable.Maps.hashMapConcat                 thrpt    5   163237650.344 ±   7371711.597  ops/s
[info] c.a.b.s.c.mutable.Maps.hashMapContainsExisting       thrpt    5   109896872.943 ±   1680673.811  ops/s
[info] c.a.b.s.c.mutable.Maps.hashMapContainsNonExisting    thrpt    5   202864615.458 ±   8367105.404  ops/s
[info] c.a.b.s.c.mutable.Maps.hashMapRemove                 thrpt    5    12472815.858 ±   8131555.647  ops/s
[info] c.a.b.s.c.mutable.Maps.listMapAdd                    thrpt    5     2614317.962 ±    136328.283  ops/s
[info] c.a.b.s.c.mutable.Maps.listMapConcat                 thrpt    5      189078.562 ±     32727.173  ops/s
[info] c.a.b.s.c.mutable.Maps.listMapContainsExisting       thrpt    5    28924796.901 ±    823682.233  ops/s
[info] c.a.b.s.c.mutable.Maps.listMapContainsNonExisting    thrpt    5     9194517.783 ±     54373.923  ops/s
[info] c.a.b.s.c.mutable.Maps.listMapRemove                 thrpt    5     2895687.709 ±     91358.191  ops/s
[info] c.a.b.s.c.mutable.Maps.treeMapAdd                    thrpt    5    15335656.364 ±   1335285.913  ops/s
[info] c.a.b.s.c.mutable.Maps.treeMapConcat                 thrpt    5   309818129.561 ±  10403042.543  ops/s
[info] c.a.b.s.c.mutable.Maps.treeMapContainsExisting       thrpt    5    60566731.512 ±   4745650.796  ops/s
[info] c.a.b.s.c.mutable.Maps.treeMapContainsNonExisting    thrpt    5    38260802.571 ±   3413861.094  ops/s
[info] c.a.b.s.c.mutable.Maps.treeMapRemove                 thrpt    5    18936315.622 ±   1491918.934  ops/s
[info] c.a.b.s.c.mutable.Seqs.baseline                      thrpt    5  3675395386.109 ± 529573226.588  ops/s
[info] c.a.b.s.c.mutable.Seqs.linkedListConcat              thrpt    5          12.082 ±         1.537  ops/s
[info] c.a.b.s.c.mutable.Seqs.linkedListHead                thrpt    5   391378197.169 ±  33855393.902  ops/s
[info] c.a.b.s.c.mutable.Seqs.linkedListLast                thrpt    5          21.411 ±         0.721  ops/s
[info] c.a.b.s.c.mutable.Seqs.linkedListTail                thrpt    5   372894506.951 ±  28729547.486  ops/s
[info] c.a.b.s.c.mutable.Seqs.listAppend                    thrpt    5          11.542 ±         1.394  ops/s
[info] c.a.b.s.c.mutable.Seqs.listMap                       thrpt    5           3.364 ±         1.668  ops/s
[info] c.a.b.s.c.mutable.Seqs.listPrepend                   thrpt    5   207368153.880 ±  15015268.223  ops/s
[info] c.a.b.s.c.mutable.Seqs.vectorAppend                  thrpt    5    32586676.845 ±   3426717.291  ops/s
[info] c.a.b.s.c.mutable.Seqs.vectorConcat                  thrpt    5          36.946 ±         0.852  ops/s
[info] c.a.b.s.c.mutable.Seqs.vectorHead                    thrpt    5   382255294.775 ±  30945675.694  ops/s
[info] c.a.b.s.c.mutable.Seqs.vectorLast                    thrpt    5   341458155.615 ±  10717556.202  ops/s
[info] c.a.b.s.c.mutable.Seqs.vectorMap                     thrpt    5          14.372 ±         0.847  ops/s
[info] c.a.b.s.c.mutable.Seqs.vectorPrepend                 thrpt    5    11355592.675 ±    149692.873  ops/s
[info] c.a.b.s.c.mutable.Seqs.vectorTail                    thrpt    5    43773314.444 ±   3743863.286  ops/s