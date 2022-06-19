
describe("maxArea", function () {

    it("[1,8,6,2,5,4,8,3,7], return 49", function() {
      assert.equal(maxArea([1,8,6,2,5,4,8,3,7]), 49);
    });

    it("[1, 1] , return 1", function() {
        assert.equal(maxArea([1, 1]), 1);
      });

  
  });