package org.treasure.chest.dev.template.util;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-09-07 17:27
 */
public class SynonymHandler {

    public static void main(String[] args) {
        List<String[]> lineArrays = FileUtils.readTextLines("C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\FSD\\搜索\\segment.dic", FileUtils.StringSeparator.DIAMOND);
        List<String[]> localLineArrays = FileUtils.readTextLines("C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\FSD\\搜索\\synonym.txt", FileUtils.StringSeparator.COMMA);
        List<String[]> mergeWordsArrays = FileUtils.readTextLines("C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\FSD\\搜索\\auto_merge_words0915.txt", FileUtils.StringSeparator.COMMA);
        if (CollectionUtils.isEmpty(lineArrays)){
            System.out.println("未读取到行...");
            return;
        }

        //提取热词
//        mergeWordsArrays.stream()
//                .flatMap(lineArray -> {
//                    return Arrays.stream(lineArray)
//                            .filter(word -> word.length() <= 4 && word.length() >1);
////                            .filter(word -> word.length() > 4);
//                })
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);





        // 本地同义词词库
//        HashMap<String, Integer> countMap = Maps.newHashMap();
//        List<HashMap<String, String>> mergeLocalWords = localLineArrays.stream()
//                .flatMap(lineArray -> {
//                    String reduce = Arrays.stream(lineArray)
//                            .map(word -> {
//                                Integer count = countMap.get(word);
//                                if (Objects.isNull(count) || count.equals(0)){
//                                    countMap.put(word, 1);
//                                }else {
//                                    countMap.put(word, count + 1);
//                                }
//                                return word;
//                            })
//                            .reduce((m, n) -> m.concat("," + n)).orElse("");
//                    return Arrays.stream(lineArray)
//                            .map(word -> {
//                                HashMap<String, String> map = Maps.newHashMapWithExpectedSize(1);
//                                map.put(word, reduce);
//                                return map;
//                            });
//                }).collect(Collectors.toList());
//        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            if (value > 1){
//                System.out.println(JackJsonUtils.objToJsonCatchException(entry));
//                List<String> sameList = mergeWordsArrays.stream()
//                        .filter(lineArray -> Arrays.stream(lineArray)
//                                .anyMatch(word -> word.equals(key)))
//                        .map(lineArray -> {
//                            String reduce = Arrays.stream(lineArray)
//                                    .reduce((m, n) -> m.concat("," + n)).orElse("");
//                            return reduce;
//                        }).collect(Collectors.toList());
//                sameList.stream().
//            }
//        }
        mergeWordsArrays.stream()
                .map(lineArray -> {
                    String reduce = Arrays.stream(lineArray)
                            .filter(word -> word.length() <= 4)
                            .distinct()
                            .sorted()
                            .reduce((m, n) -> m.concat("," + n)).orElse("");
                    return reduce;
                })
                .distinct()
                .sorted()
                .forEach(System.out::println);



//        // 多点同义词词库(基于词元)
//        List<HashMap<String, String>> targetWords = lineArrays.stream()
//                .filter(lineArray -> lineArray.length > 3 && !StringUtils.isEmpty(lineArray[2]))
//                .map(lineArray -> {
//                    String wordUnit = lineArray[0];
//                    String synonymWords = lineArray[2];
//                    String wholeWords = wordUnit.concat("," + synonymWords);
//                    HashMap<String, String> map = Maps.newHashMapWithExpectedSize(1);
//                    map.put(wordUnit, wholeWords);
//                    return map;
//                }).collect(Collectors.toList());
//
//        // 多点同义词词库
//        List<HashMap<String, String>> targetWordsAll = lineArrays.stream()
//                .filter(lineArray -> lineArray.length > 3 && !StringUtils.isEmpty(lineArray[2]))
//                .flatMap(lineArray -> {
//                    String wordUnit = lineArray[0];
//                    String synonymWords = lineArray[2];
//                    String wholeWords = wordUnit.concat("," + synonymWords);
//                    String[] wholeWordsSplit = wholeWords.split(FileUtils.StringSeparator.COMMA);
//                    return Arrays.stream(wholeWordsSplit)
//                            .map(word -> {
//                                HashMap<String, String> map = Maps.newHashMapWithExpectedSize(1);
//                                map.put(word, wholeWords);
//                                return map;
//                            });
//                }).collect(Collectors.toList());
//        System.out.println("=======================dmall words========================");
//        targetWordsAll.stream()
//                .map(map -> map.values().stream().findFirst().get())
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);
//
//
//        // 本地同义词词库
//        List<HashMap<String, String>> localWords = localLineArrays.stream()
//                .flatMap(lineArray -> {
//                    String reduce = Arrays.stream(lineArray).reduce((m, n) -> m.concat("," + n)).orElse("");
//                    return Arrays.stream(lineArray)
//                            .map(word -> {
//                                HashMap<String, String> map = Maps.newHashMapWithExpectedSize(1);
//                                map.put(word, reduce);
//                                return map;
//                            });
//                }).collect(Collectors.toList());
//
//        System.out.println("=======================fsd Words========================");
//        localWords.stream()
//                .map(map -> map.values().stream().findFirst().get())
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);
//
//
////        System.out.println(JackJsonUtils.objToJsonCatchException(targetWordsAll));
////        System.out.println(targetWords.size());
////        targetWords.stream().forEach(map -> System.out.println(map.values()));
//
//
////        System.out.println(JackJsonUtils.objToJsonCatchException(localWords));
//
////        System.out.println("-");
////        System.out.println("-");
////        System.out.println("-");
////        System.out.println("-");
////        System.out.println("-");
//        System.out.println("=======================merge words========================");
//        targetWordsAll.addAll(localWords);
//        Map<String, String> reduceWordsMap = Maps.newHashMap();
//        targetWordsAll.stream()
//                .forEach(wordsMap -> {
//                    String key = wordsMap.keySet().stream().findFirst().get();
//                    String newWords = wordsMap.get(key);
//                    String words = reduceWordsMap.get(key);
//                    if (!StringUtils.isEmpty(words)) {
//                        List<String> array1 = Arrays.asList(words.split(FileUtils.StringSeparator.COMMA));
//                        List<String> array2 = Arrays.asList(newWords.split(FileUtils.StringSeparator.COMMA));
//                        List<String> reduceList = Lists.newArrayList();
//                        reduceList.addAll(array1);
//                        reduceList.addAll(array2);
//                        String reduceWords = reduceList.stream()
//                                .distinct()
//                                .reduce((m, n) -> m.concat("," + n)).orElse("");
//                        reduceWordsMap.put(key, reduceWords);
//                    }else {
//                        reduceWordsMap.putAll(wordsMap);
//                    }
//                });
////        System.out.println(JackJsonUtils.objToJsonCatchException(reduceWordsMap));
//        reduceWordsMap.values().stream()
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);

    }



}
