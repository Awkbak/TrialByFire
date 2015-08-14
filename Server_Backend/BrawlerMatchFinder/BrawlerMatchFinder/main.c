#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){
	char line[17];
	int stats[2];
	stats[0] = 0;
	stats[1] = 0;
	char input[17];
	fgets(input, 16, stdin);

	FILE *data;
	errno_t err;

	err = fopen_s(&data, "DATA.data", "r");

	if (err != 0) {
		fprintf(stderr, "Can't open input file!\n");
		exit(1);
	}
	while (fgets(line, 17, data) != NULL){
		if ((line[0] == input[0] && line[1] == input[1] && line[2] == input[2] && line[3] == input[3] && line[4] == input[4] && line[5] == input[5] && line[6] == input[6] && line[7] == input[7]) ||
			(line[4] == input[0] && line[5] == input[1] && line[6] == input[2] && line[7] == input[3] && line[0] == input[4] && line[1] == input[5] && line[2] == input[6] && line[3] == input[7])){
			stats[0]++;
			if (line[8] == '1'){
				stats[1]++;
			}
		}
	}
	if (stats[0] == 0){
		printf("-1");
	}
	else{
		printf("%f", ((double)stats[1]) / stats[0]);
	}
}