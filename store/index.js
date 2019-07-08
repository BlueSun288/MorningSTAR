import vue from 'vue'

export const state = () => ({
	price: 0
});
export const mutations = {
	addToPrice(num) {
		state.price += num;
	}
};