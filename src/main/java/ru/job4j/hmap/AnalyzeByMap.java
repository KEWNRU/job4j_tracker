package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        int i = 0;
        for (Pupil key : pupils) {
            for (Subject subject : key.subjects()) {
                rsl += subject.score();
                i++;
            }
        }
        return rsl / i;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil key : pupils) {
            int i = 0;
            double rsl = 0;
            for (Subject subject : key.subjects()) {
                rsl += subject.score();
                i++;
            }
            list.add(new Label(key.name(), rsl / i));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> list = new LinkedHashMap<>();
        for (Pupil key : pupils) {
            for (Subject subject : key.subjects()) {
                int score = list.getOrDefault(subject.name(), 0) + subject.score();
                list.put(subject.name(), score);
            }
        }
        List<Label> lists = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            lists.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return lists;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil key : pupils) {
            int rsl = 0;
            for (Subject subject : key.subjects()) {
                rsl += subject.score();
                list.add(new Label(key.name(), rsl));
            }
            list.sort(Comparator.naturalOrder());
        }
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> list = new LinkedHashMap<>();
        List<Label> lists = new ArrayList<>();
        for (Pupil key : pupils) {
            for (Subject subject : key.subjects()) {
                int score = list.getOrDefault(subject.name(), 0) + subject.score();
                list.put(subject.name(), score);
            }
        }
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            lists.add(new Label(entry.getKey(), entry.getValue()));
        }
        lists.sort(Comparator.naturalOrder());
        return lists.get(lists.size() - 1);
    }
}
