describe("maxSubArray", function() {

    it("[1], return 1", function() {
      assert.equal(maxSubArray([1]), 1);
    });

    it("[-2,1,-3,4,-1,2,1,-5,4], return 6", function() {
        assert.equal(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]), 6);
      });

    it("[5,4,-1,7,8], return 23", function() {
        assert.equal(maxSubArray([5,4,-1,7,8]), 23);
    });

    it("[-1], return -1", function() {
        assert.equal(maxSubArray([-1]), -1);
    });
  
  });