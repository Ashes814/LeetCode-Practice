
describe("groupAnagrams", function () {

    it("3", function() {
      assert.equal(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]), [["bat"],["nat","tan"],["ate","eat","tea"]]);
    });
  
    it("3", function() {
    assert.equal(groupAnagrams([""]), [[""]]);
    });

    it("3", function() {
    assert.equal(groupAnagrams(["a"]), [["a"]]);
    });
  
  });