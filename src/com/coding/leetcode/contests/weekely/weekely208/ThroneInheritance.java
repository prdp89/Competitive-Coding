package com.coding.leetcode.contests.weekely.weekely208;

import java.util.*;

public class ThroneInheritance {

    String root;

    //We are just creating Family Hierarchy here : Parent --> child --> grandChild
    Map<String, List<String>> family;

    //storing dead members of family
    Set<String> deads;

    public ThroneInheritance( String kingName ) {
        root = kingName;
        family = new HashMap<>();
        deads = new HashSet<>();

        family.putIfAbsent(kingName, new ArrayList<>());
    }

    //https://leetcode.com/contest/weekly-contest-208/problems/throne-inheritance/
    public static void main( String[] args ) {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        throneInheritance.birth("bob", "asha");

        throneInheritance.getInheritanceOrder().forEach(System.out::print);

        throneInheritance.death("bob");
        System.out.println("\n");

        throneInheritance.getInheritanceOrder().forEach(System.out::print);
    }

    public void birth( String parentName, String childName ) {
        //storing hierarchy of Parent-child relationship using map
        family.get(parentName).add(childName);

        //Now Child can have different hierarchy as well
        family.putIfAbsent(childName, new ArrayList<>());

    }

    public void death( String name ) {
        deads.add(name);
    }

    //to get the Family tree order : Oldest to Newest : We are doing In-order traversal
    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs( String root, List<String> res ) {
        //if member if not dead add into the result.
        if (!deads.contains(root)) {
            res.add(root);
        }

        for (String child : family.get(root)) {
            dfs(child, res);
        }
    }
}
